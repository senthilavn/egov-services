package org.egov.egf.instrument.persistence.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.egov.common.domain.model.Pagination;
import org.egov.common.persistence.repository.JdbcRepository;
import org.egov.egf.instrument.domain.model.Instrument;
import org.egov.egf.instrument.domain.model.InstrumentSearch;
import org.egov.egf.instrument.persistence.entity.InstrumentEntity;
import org.egov.egf.instrument.persistence.entity.InstrumentSearchEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class InstrumentJdbcRepository extends JdbcRepository {
	private static final Logger LOG = LoggerFactory.getLogger(InstrumentJdbcRepository.class);

	static {
		LOG.debug("init instrument");
		init(InstrumentEntity.class);
		LOG.debug("end init instrument");
	}

	public InstrumentJdbcRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public InstrumentEntity create(InstrumentEntity entity) {

		entity.setId(UUID.randomUUID().toString().replace("-", ""));
		super.create(entity);
		return entity;
	}

	public InstrumentEntity update(InstrumentEntity entity) {
		super.update(entity);
		return entity;

	}

	public Pagination<Instrument> search(InstrumentSearch domain) {
		InstrumentSearchEntity instrumentSearchEntity = new InstrumentSearchEntity();
		instrumentSearchEntity.toEntity(domain);

		String searchQuery = "select :selectfields from :tablename :condition  :orderby   ";

		Map<String, Object> paramValues = new HashMap<>();
		StringBuffer params = new StringBuffer();

		if (instrumentSearchEntity.getSortBy() != null && !instrumentSearchEntity.getSortBy().isEmpty()) {
			validateSortByOrder(instrumentSearchEntity.getSortBy());
			validateEntityFieldName(instrumentSearchEntity.getSortBy(), InstrumentEntity.class);
		}

		String orderBy = "order by id";
		if (instrumentSearchEntity.getSortBy() != null && !instrumentSearchEntity.getSortBy().isEmpty())
			orderBy = "order by " + instrumentSearchEntity.getSortBy();

		searchQuery = searchQuery.replace(":tablename", InstrumentEntity.TABLE_NAME);

		searchQuery = searchQuery.replace(":selectfields", " * ");

		// implement jdbc specfic search
		if (instrumentSearchEntity.getId() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("id =:id");
			paramValues.put("id", instrumentSearchEntity.getId());
		}
		if (instrumentSearchEntity.getTransactionNumber() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("transactionNumber =:transactionNumber");
			paramValues.put("transactionNumber", instrumentSearchEntity.getTransactionNumber());
		}
		if (instrumentSearchEntity.getTransactionDate() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("transactionDate =:transactionDate");
			paramValues.put("transactionDate", instrumentSearchEntity.getTransactionDate());
		}
		if (instrumentSearchEntity.getAmount() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("amount =:amount");
			paramValues.put("amount", instrumentSearchEntity.getAmount());
		}
		if (instrumentSearchEntity.getInstrumentTypeId() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("instrumentType =:instrumentType");
			paramValues.put("instrumentType", instrumentSearchEntity.getInstrumentTypeId());
		}
		if (instrumentSearchEntity.getBankId() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("bank =:bank");
			paramValues.put("bank", instrumentSearchEntity.getBankId());
		}
		if (instrumentSearchEntity.getBranchName() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("branchName =:branchName");
			paramValues.put("branchName", instrumentSearchEntity.getBranchName());
		}
		if (instrumentSearchEntity.getBankAccountId() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("bankAccount =:bankAccount");
			paramValues.put("bankAccount", instrumentSearchEntity.getBankAccountId());
		}
		if (instrumentSearchEntity.getInstrumentStatusId() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("instrumentStatus =:instrumentStatus");
			paramValues.put("instrumentStatus", instrumentSearchEntity.getInstrumentStatusId());
		}
		if (instrumentSearchEntity.getTransactionTypeId() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("transactionType =:transactionType");
			paramValues.put("transactionType", instrumentSearchEntity.getTransactionTypeId());
		}
		if (instrumentSearchEntity.getPayee() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("payee =:payee");
			paramValues.put("payee", instrumentSearchEntity.getPayee());
		}
		if (instrumentSearchEntity.getDrawer() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("drawer =:drawer");
			paramValues.put("drawer", instrumentSearchEntity.getDrawer());
		}
		if (instrumentSearchEntity.getSurrendarReasonId() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("surrendarReason =:surrendarReason");
			paramValues.put("surrendarReason", instrumentSearchEntity.getSurrendarReasonId());
		}
		if (instrumentSearchEntity.getSerialNo() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("serialNo =:serialNo");
			paramValues.put("serialNo", instrumentSearchEntity.getSerialNo());
		}
		/*if (instrumentSearchEntity.getInstrumentVouchers() != null) {
			if (params.length() > 0)
				params.append(" and ");
			params.append("instrumentVouchers =:instrumentVouchers");
			paramValues.put("instrumentVouchers", instrumentSearchEntity.getInstrumentVouchers());
		}*/

		Pagination<Instrument> page = new Pagination<>();
		if (instrumentSearchEntity.getOffset() != null)
			page.setOffset(instrumentSearchEntity.getOffset());
		if (instrumentSearchEntity.getPageSize() != null)
			page.setPageSize(instrumentSearchEntity.getPageSize());

		if (params.length() > 0) {

			searchQuery = searchQuery.replace(":condition", " where " + params.toString());

		} else {
			searchQuery = searchQuery.replace(":condition", "");
		}

		searchQuery = searchQuery.replace(":orderby", orderBy);

		page = (Pagination<Instrument>) getPagination(searchQuery, page, paramValues);
		searchQuery = searchQuery + " :pagination";

		searchQuery = searchQuery.replace(":pagination",
				"limit " + page.getPageSize() + " offset " + page.getOffset() * page.getPageSize());

		BeanPropertyRowMapper row = new BeanPropertyRowMapper(InstrumentEntity.class);

		List<InstrumentEntity> instrumentEntities = namedParameterJdbcTemplate.query(searchQuery.toString(),
				paramValues, row);

		page.setTotalResults(instrumentEntities.size());

		List<Instrument> instruments = new ArrayList<>();
		for (InstrumentEntity instrumentEntity : instrumentEntities) {

			instruments.add(instrumentEntity.toDomain());
		}
		page.setPagedData(instruments);

		return page;
	}

	public InstrumentEntity findById(InstrumentEntity entity) {
		List<String> list = allUniqueFields.get(entity.getClass().getSimpleName());

		Map<String, Object> paramValues = new HashMap<>();

		for (String s : list) {
			paramValues.put(s, getValue(getField(entity, s), entity));
		}

		List<InstrumentEntity> instruments = namedParameterJdbcTemplate.query(
				getByIdQuery.get(entity.getClass().getSimpleName()).toString(), paramValues,
				new BeanPropertyRowMapper(InstrumentEntity.class));
		if (instruments.isEmpty()) {
			return null;
		} else {
			return instruments.get(0);
		}

	}

}