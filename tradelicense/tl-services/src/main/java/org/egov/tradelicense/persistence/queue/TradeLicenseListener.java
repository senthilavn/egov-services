package org.egov.tradelicense.persistence.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.egov.tl.commons.web.contract.RequestInfo;
import org.egov.tl.commons.web.contract.TradeLicenseContract;
import org.egov.tl.commons.web.requests.TradeLicenseIndexerRequest;
import org.egov.tl.commons.web.requests.TradeLicenseRequest;
import org.egov.tradelicense.common.config.PropertiesManager;
import org.egov.tradelicense.domain.model.LicenseSearch;
import org.egov.tradelicense.domain.model.TradeLicense;
import org.egov.tradelicense.domain.repository.TradeLicenseESRepository;
import org.egov.tradelicense.domain.service.NoticeDocumentService;
import org.egov.tradelicense.domain.service.TradeLicenseService;
import org.egov.tradelicense.web.contract.DemandResponse;
import org.egov.tradelicense.web.contract.NoticeDocumentRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TradeLicenseListener {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	TradeLicenseProducer tradeLicenseProducer;

	@Autowired
	PropertiesManager propertiesManager;

	@Autowired
	TradeLicenseService tradeLicenseService;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	TradeLicenseESRepository tradeLicenseESRepository;
	
	@Autowired
	NoticeDocumentService noticeDocumentService;

	@KafkaListener(topics = { "#{propertiesManager.getTradeLicenseWorkFlowPopulatedTopic()}",
	        "${kafka.topics.demandBill.update.name}", "${kafka.topics.noticedocument.create.name}",
                        "${kafka.topics.noticedocument.update.name}"})
	public void process(Map<String, Object> mastersMap,
	        @Header(KafkaHeaders.RECEIVED_TOPIC) final String receivedTopic) {

		String topic = propertiesManager.getTradeLicensePersistedTopic();
		String key = propertiesManager.getTradeLicensePersistedKey();
		TradeLicenseIndexerRequest indexerRequest;
		if (mastersMap.get("tradelicense-legacy-create") != null) {

			TradeLicenseRequest request = objectMapper.convertValue(mastersMap.get("tradelicense-legacy-create"),
					TradeLicenseRequest.class);

			ModelMapper mapper = new ModelMapper();
			mapper.getConfiguration().setAmbiguityIgnored(true);
			for (TradeLicenseContract tradeLicenseContract : request.getLicenses()) {
				TradeLicense domain = mapper.map(tradeLicenseContract, TradeLicense.class);
				TradeLicense tradeLicense = tradeLicenseService.save(domain);
			}
			mastersMap.clear();
			indexerRequest = tradeLicenseESRepository.getTradeLicenseIndexerRequest(request);
			mastersMap.put("tradelicense-persisted", indexerRequest);
			tradeLicenseProducer.sendMessage(topic, key, mastersMap);
		}
		if (mastersMap.get("tradelicense-new-create") != null) {

			TradeLicenseRequest request = objectMapper.convertValue(mastersMap.get("tradelicense-new-create"),
					TradeLicenseRequest.class);

			ModelMapper mapper = new ModelMapper();
			mapper.getConfiguration().setAmbiguityIgnored(true);
			for (TradeLicenseContract tradeLicenseContract : request.getLicenses()) {
				TradeLicense domain = mapper.map(tradeLicenseContract, TradeLicense.class);
				tradeLicenseService.save(domain);
			}
			mastersMap.clear();
			indexerRequest = tradeLicenseESRepository.getTradeLicenseIndexerRequest(request);
			mastersMap.put("tradelicense-persisted", indexerRequest);
			tradeLicenseProducer.sendMessage(topic, key, mastersMap);
		}
		if (mastersMap.get("tradelicense-legacy-update") != null) {

			TradeLicenseRequest request = objectMapper.convertValue(mastersMap.get("tradelicense-legacy-update"),
					TradeLicenseRequest.class);

			ModelMapper mapper = new ModelMapper();
			mapper.getConfiguration().setAmbiguityIgnored(true);
			for (TradeLicenseContract tradeLicenseContract : request.getLicenses()) {
				TradeLicense domain = mapper.map(tradeLicenseContract, TradeLicense.class);
				tradeLicenseService.update(domain, request.getRequestInfo());
			}
			mastersMap.clear();
			indexerRequest = tradeLicenseESRepository.getTradeLicenseIndexerRequest(request);
			mastersMap.put("tradelicense-persisted", indexerRequest);
			tradeLicenseProducer.sendMessage(topic, key, mastersMap);
		}
		if (mastersMap.get("tradelicense-new-update") != null) {

			TradeLicenseRequest request = objectMapper.convertValue(mastersMap.get("tradelicense-new-update"),
					TradeLicenseRequest.class);

			ModelMapper mapper = new ModelMapper();
			mapper.getConfiguration().setAmbiguityIgnored(true);
			for (TradeLicenseContract tradeLicenseContract : request.getLicenses()) {
				TradeLicense domain = mapper.map(tradeLicenseContract, TradeLicense.class);
				tradeLicenseService.update(domain, request.getRequestInfo());
			}
			mastersMap.clear();
			indexerRequest = tradeLicenseESRepository.getTradeLicenseIndexerRequest(request);
			mastersMap.put("tradelicense-persisted", indexerRequest);
			tradeLicenseProducer.sendMessage(topic, key, mastersMap);
		}
		if (receivedTopic != null && receivedTopic.equalsIgnoreCase(propertiesManager.getUpdateDemandBillTopicName())) {
			
			System.out.println(receivedTopic.toString());
			DemandResponse consumerRecord = objectMapper.convertValue(mastersMap,
                            DemandResponse.class);
			System.out.println(consumerRecord.toString());
            tradeLicenseService
                    .updateTradeLicenseAfterCollection(objectMapper.convertValue(consumerRecord, DemandResponse.class));
            RequestInfo requestInfo = tradeLicenseService.createRequestInfoFromResponseInfo(consumerRecord.getResponseInfo());
            LicenseSearch licenseSearch = LicenseSearch.builder().applicationNumber(consumerRecord.getDemands().get(0).getConsumerCode()).build();
            System.out.println(licenseSearch.toString());
            TradeLicense tradeLicense = tradeLicenseService.findLicense(licenseSearch);
            System.out.println(tradeLicense.toString());
            tradeLicenseService.update(tradeLicense, requestInfo);
            // prepare trade license request and put into indexer topic
            requestInfo.setAction("new-update");
            TradeLicenseRequest tradeLicenseRequest = new TradeLicenseRequest();
            List<TradeLicenseContract> licenses = new ArrayList<TradeLicenseContract>();
            ModelMapper mapper = new ModelMapper();
			mapper.getConfiguration().setAmbiguityIgnored(true);
			TradeLicenseContract tradeLicenseContract = mapper.map(tradeLicense, TradeLicenseContract.class);
            licenses.add(tradeLicenseContract);
            tradeLicenseRequest.setRequestInfo(requestInfo);
            tradeLicenseRequest.setLicenses(licenses);
            indexerRequest = tradeLicenseESRepository.getTradeLicenseIndexerRequest(tradeLicenseRequest);
            System.out.println(indexerRequest.toString());
            mastersMap.put("tradelicense-persisted", indexerRequest);
			tradeLicenseProducer.sendMessage(topic, key, mastersMap);
        }
		if (receivedTopic != null && receivedTopic.equalsIgnoreCase(propertiesManager.getNoticeDocumentCreateTopic())) {
		    NoticeDocumentRequest noticeDocumentRequest = objectMapper.convertValue(mastersMap,
		            NoticeDocumentRequest.class);
		    noticeDocumentService.create(noticeDocumentRequest);
		}
		if (receivedTopic != null && receivedTopic.equalsIgnoreCase(propertiesManager.getNoticeDocumentUpdateTopic())) {
                    NoticeDocumentRequest noticeDocumentRequest = objectMapper.convertValue(mastersMap,
                            NoticeDocumentRequest.class);
                    noticeDocumentService.update(noticeDocumentRequest);
                }
	}

}