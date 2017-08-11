package org.egov.egf.master.domain.repository;

import java.util.HashMap;
import java.util.Map;

import org.egov.common.constants.Constants;
import org.egov.common.domain.model.Pagination;
import org.egov.egf.master.domain.model.FinancialYear;
import org.egov.egf.master.domain.model.FinancialYearSearch;
import org.egov.egf.master.persistence.entity.FinancialYearEntity;
import org.egov.egf.master.persistence.queue.MastersQueueRepository;
import org.egov.egf.master.persistence.repository.FinancialYearJdbcRepository;
import org.egov.egf.master.web.requests.FinancialYearRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialYearRepository {

	@Autowired
	private FinancialYearJdbcRepository financialYearJdbcRepository;
	@Autowired
	private MastersQueueRepository financialYearQueueRepository;

	public FinancialYear findById(FinancialYear financialYear) {
		return financialYearJdbcRepository.findById(new FinancialYearEntity().toEntity(financialYear)).toDomain();

	}

	public FinancialYear save(FinancialYear financialYear) {
		return financialYearJdbcRepository.create(new FinancialYearEntity().toEntity(financialYear)).toDomain();
	}

	public FinancialYear update(FinancialYear entity) {
		return financialYearJdbcRepository.update(new FinancialYearEntity().toEntity(entity)).toDomain();
	}

	public void add(FinancialYearRequest request) {
	
		Map<String, Object> message = new HashMap<>();

		if (request.getRequestInfo().getAction().equalsIgnoreCase(Constants.ACTION_CREATE)) {
			message.put("financialyear_create", request);
		} else {
			message.put("financialyear_update", request);
		}
		financialYearQueueRepository.add(message);
	}

	public Pagination<FinancialYear> search(FinancialYearSearch domain) {

		return financialYearJdbcRepository.search(domain);

	}

}