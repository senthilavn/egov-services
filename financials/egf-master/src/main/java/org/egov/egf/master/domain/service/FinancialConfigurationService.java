package org.egov.egf.master.domain.service;

import java.util.List;

import org.egov.common.domain.exception.CustomBindException;
import org.egov.common.domain.model.Pagination;
import org.egov.egf.master.domain.model.FinancialConfiguration;
import org.egov.egf.master.domain.model.FinancialConfigurationSearch;
import org.egov.egf.master.domain.repository.FinancialConfigurationRepository;
import org.egov.egf.master.web.requests.FinancialConfigurationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.SmartValidator;

@Service
@Transactional(readOnly = true)
public class FinancialConfigurationService {

	public static final String ACTION_CREATE = "create";
	public static final String ACTION_UPDATE = "update";
	public static final String ACTION_VIEW = "view";
	public static final String ACTION_EDIT = "edit";
	public static final String ACTION_SEARCH = "search";

	@Autowired
	private FinancialConfigurationRepository financialConfigurationRepository;

	@Autowired
	private SmartValidator validator;

	private BindingResult validate(List<FinancialConfiguration> financialconfigurations, String method,
			BindingResult errors) {

		try {
			switch (method) {
			case ACTION_VIEW:
				// validator.validate(financialConfigurationContractRequest.getFinancialConfiguration(),
				// errors);
				break;
			case ACTION_CREATE:
				Assert.notNull(financialconfigurations, "FinancialConfigurations to create must not be null");
				for (FinancialConfiguration financialConfiguration : financialconfigurations) {
					validator.validate(financialConfiguration, errors);
				}
				break;
			case ACTION_UPDATE:
				Assert.notNull(financialconfigurations, "FinancialConfigurations to update must not be null");
				for (FinancialConfiguration financialConfiguration : financialconfigurations) {
					validator.validate(financialConfiguration, errors);
				}
				break;
			default:

			}
		} catch (IllegalArgumentException e) {
			errors.addError(new ObjectError("Missing data", e.getMessage()));
		}
		return errors;

	}

	public List<FinancialConfiguration> fetchRelated(List<FinancialConfiguration> financialconfigurations) {
		for (FinancialConfiguration financialConfiguration : financialconfigurations) {
			// fetch related items

		}

		return financialconfigurations;
	}

	@Transactional
	public List<FinancialConfiguration> add(List<FinancialConfiguration> financialconfigurations,
			BindingResult errors) {
		financialconfigurations = fetchRelated(financialconfigurations);
		validate(financialconfigurations, ACTION_CREATE, errors);
		if (errors.hasErrors()) {
			throw new CustomBindException(errors);
		}
		return financialconfigurations;

	}

	@Transactional
	public List<FinancialConfiguration> update(List<FinancialConfiguration> financialconfigurations,
			BindingResult errors) {
		financialconfigurations = fetchRelated(financialconfigurations);
		validate(financialconfigurations, ACTION_UPDATE, errors);
		if (errors.hasErrors()) {
			throw new CustomBindException(errors);
		}
		return financialconfigurations;

	}

	public void addToQue(FinancialConfigurationRequest request) {
		financialConfigurationRepository.add(request);
	}

	public Pagination<FinancialConfiguration> search(FinancialConfigurationSearch financialConfigurationSearch) {
		return financialConfigurationRepository.search(financialConfigurationSearch);
	}

	@Transactional
	public FinancialConfiguration save(FinancialConfiguration financialConfiguration) {
		return financialConfigurationRepository.save(financialConfiguration);
	}

	@Transactional
	public FinancialConfiguration update(FinancialConfiguration financialConfiguration) {
		return financialConfigurationRepository.update(financialConfiguration);
	}

}