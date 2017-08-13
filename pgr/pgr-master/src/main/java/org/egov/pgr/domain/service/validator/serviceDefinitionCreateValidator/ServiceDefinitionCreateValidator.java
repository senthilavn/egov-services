package org.egov.pgr.domain.service.validator.serviceDefinitionCreateValidator;

import java.util.HashMap;
import java.util.List;

import org.egov.pgr.domain.exception.PGRMasterException;
import org.egov.pgr.domain.model.ServiceDefinition;
import org.egov.pgr.persistence.repository.ServiceDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDefinitionCreateValidator implements ServiceDefinitionValidator {

	@Autowired
	private ServiceDefinitionRepository serviceDefinitionRepository;

	@Override
	public boolean canValidate(ServiceDefinition serviceDefinition) {
		return true;
	}

	@Override
	public void checkMandatoryField(ServiceDefinition serviceDefinition) {

		if (serviceDefinition.isTenantIdAbsent()) {
			HashMap<String, String> error = new HashMap<>();

			error.put("code", "tanantId Vaalidator.1");
			error.put("field", "ServiceDefinition.tanantId");
			error.put("message", "tanantId mandatory");

			throw new PGRMasterException(error);
		}

		if (serviceDefinition.isCodeAbsent()) {
			HashMap<String, String> error = new HashMap<>();

			error.put("code", "DefinitionCode Vaalidator.2");
			error.put("field", "ServiceDefinition.DefinitionCode");
			error.put("message", "Code mandatory ");

			throw new PGRMasterException(error);
		}
	}

	@Override
	public void checkConstraints(ServiceDefinition serviceDefinition) {

		List<org.egov.pgr.domain.model.ServiceDefinition> complaintCodeList = serviceDefinitionRepository
				.getData(serviceDefinition);

		List<org.egov.pgr.domain.model.ServiceDefinition> definitionList = serviceDefinitionRepository
				.getDefinitionCode(serviceDefinition);

		if (complaintCodeList.isEmpty()) {
			HashMap<String, String> error = new HashMap<>();
			error.put("code", "DefinitionCode Vaalidator.1");
			error.put("field", "DefinitionTypeConfiguration.ServiceCode");
			error.put("message", "ServiceCode not exist in cmplnttyp table ");
			throw new PGRMasterException(error);

		}

		if (!definitionList.isEmpty() && (definitionList.get(0).getCode().equalsIgnoreCase(serviceDefinition.getCode())
				&& definitionList.get(0).getTenantId().equalsIgnoreCase(serviceDefinition.getTenantId()))) {
			HashMap<String, String> error = new HashMap<>();
			error.put("code", "DefinitionCode Vaalidator.2");
			error.put("field", "DefinitionTypeConfiguration.code");
			error.put("message", "code already exist in definition table ");
			throw new PGRMasterException(error);

		}

	}

}