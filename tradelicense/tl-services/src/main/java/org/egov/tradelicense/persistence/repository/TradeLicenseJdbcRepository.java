package org.egov.tradelicense.persistence.repository;

import java.util.List;
import java.util.Map;

import org.egov.tradelicense.common.config.PropertiesManager;
import org.egov.tradelicense.common.persistense.repository.JdbcRepository;
import org.egov.tradelicense.domain.model.LicenseSearch;
import org.egov.tradelicense.persistence.entity.LicenseSearchEntity;
import org.egov.tradelicense.persistence.entity.TradeLicenseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TradeLicenseJdbcRepository extends JdbcRepository {

	@Autowired
	PropertiesManager propertiesManager;

	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private static final Logger LOG = LoggerFactory.getLogger(TradeLicenseJdbcRepository.class);

	static {
		LOG.debug("init accountCodePurpose");
		init(TradeLicenseEntity.class);
		LOG.debug("end init accountCodePurpose");
	}

	public TradeLicenseEntity create(TradeLicenseEntity entity) {

		super.create(entity);

		return entity;
	}

	public TradeLicenseEntity update(TradeLicenseEntity entity) {

		super.update(entity);

		return entity;
	}

	public List<TradeLicenseEntity> search(LicenseSearch domain) {

		MapSqlParameterSource paramValues = new MapSqlParameterSource();
		String searchQuery = buildTradeLicenseSearchQuery(domain, paramValues);
		List<TradeLicenseEntity> licenseEntities = namedParameterJdbcTemplate.query(searchQuery, paramValues,
				new BeanPropertyRowMapper(TradeLicenseEntity.class));

		return licenseEntities;
	}

	private String buildTradeLicenseSearchQuery(LicenseSearch domain, MapSqlParameterSource paramValues) {

		final LicenseSearchEntity licenseSearchEntity = new LicenseSearchEntity();
		licenseSearchEntity.toEntity(domain);

		String searchQuery = "select :selectfields from :tablename :condition  ";

		final StringBuffer params = new StringBuffer();

		searchQuery = searchQuery.replace(":tablename", LicenseSearchEntity.TABLE_NAME);

		searchQuery = searchQuery.replace(":selectfields", " * ");

		// implement jdbc specfic search
		if (licenseSearchEntity.getTenantId() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append("tenantId =:tenantId");
			paramValues.addValue("tenantId", licenseSearchEntity.getTenantId());
		}

		if (licenseSearchEntity.getIds() != null && licenseSearchEntity.getIds().length > 0) {

			String searchIds = "";
			int count = 1;
			for (Integer id : licenseSearchEntity.getIds()) {

				if (count < licenseSearchEntity.getIds().length)
					searchIds = searchIds + id + ",";
				else
					searchIds = searchIds + id;

				count++;
			}
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append(" id IN (" + searchIds + ") ");
		}

		if (licenseSearchEntity.getActive() != null && !licenseSearchEntity.getActive().trim().isEmpty()) {

			if (licenseSearchEntity.getActive().equalsIgnoreCase("true")) {
				if (params.length() > 0) {
					params.append(" and ");
				}
				params.append(" active = :active ");
				paramValues.addValue("active", true);
			} else if (licenseSearchEntity.getActive().equalsIgnoreCase("false")) {
				if (params.length() > 0) {
					params.append(" and ");
				}
				params.append(" active = :active ");
				paramValues.addValue("active", false);
			}

		}

		if (licenseSearchEntity.getLegacy() != null && !licenseSearchEntity.getLegacy().trim().isEmpty()) {

			if (licenseSearchEntity.getLegacy().equalsIgnoreCase("true")) {
				if (params.length() > 0) {
					params.append(" and ");
				}
				params.append(" isLegacy = :isLegacy ");
				paramValues.addValue("isLegacy", true);
			} else if (licenseSearchEntity.getLegacy().equalsIgnoreCase("false")) {
				if (params.length() > 0) {
					params.append(" and ");
				}
				params.append(" isLegacy = :isLegacy ");
				paramValues.addValue("isLegacy", false);
			}

		}

		if (licenseSearchEntity.getApplicationNumber() != null
				&& !licenseSearchEntity.getApplicationNumber().trim().isEmpty()) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append(
					" id in ( SELECT licenseId FROM egtl_license_application WHERE upper(applicationNumber)  like :applicationNumber)");
			paramValues.addValue("applicationNumber",
					'%' + licenseSearchEntity.getApplicationNumber().toUpperCase() + '%');
		}

		if (licenseSearchEntity.getLicenseNumber() != null
				&& !licenseSearchEntity.getLicenseNumber().trim().isEmpty()) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append(" upper(licenseNumber)  like  :licenseNumber ");
			paramValues.addValue("licenseNumber", '%' + licenseSearchEntity.getLicenseNumber().toUpperCase() + '%');
		}

		if (licenseSearchEntity.getApplicationStatus() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append(" id in ( SELECT licenseId FROM egtl_license_application WHERE status = '"
					+ licenseSearchEntity.getApplicationStatus() + "'" + ")");
		}

		if (licenseSearchEntity.getOldLicenseNumber() != null
				&& !licenseSearchEntity.getOldLicenseNumber().trim().isEmpty()) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append(" upper(oldLicenseNumber) like :oldLicenseNumber ");
			paramValues.addValue("oldLicenseNumber",
					'%' + licenseSearchEntity.getOldLicenseNumber().toUpperCase() + '%');
		}

		if (licenseSearchEntity.getMobileNumber() != null && !licenseSearchEntity.getMobileNumber().trim().isEmpty()) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append(" mobileNumber = :mobileNumber ");
			paramValues.addValue("mobileNumber", licenseSearchEntity.getMobileNumber());
		}

		if (licenseSearchEntity.getAadhaarNumber() != null
				&& !licenseSearchEntity.getAadhaarNumber().trim().isEmpty()) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append(" adhaarNumber = :adhaarNumber ");
			paramValues.addValue("adhaarNumber", licenseSearchEntity.getAadhaarNumber());
		}

		if (licenseSearchEntity.getEmailId() != null && !licenseSearchEntity.getEmailId().trim().isEmpty()) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append(" emailId = :emailId ");
			paramValues.addValue("emailId", licenseSearchEntity.getEmailId());
		}

		if (licenseSearchEntity.getPropertyAssesmentNo() != null
				&& !licenseSearchEntity.getPropertyAssesmentNo().trim().isEmpty()) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append(" upper(propertyAssesmentNo) like :propertyAssesmentNo ");
			paramValues.addValue("propertyAssesmentNo",
					'%' + licenseSearchEntity.getPropertyAssesmentNo().toUpperCase() + '%');
		}

		if (licenseSearchEntity.getAdminWard() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append(" adminWardId = :adminWardId ");
			paramValues.addValue("adminWardId", licenseSearchEntity.getAdminWard());
		}

		if (licenseSearchEntity.getLocality() != null) {
			params.append(" localityId = :localityId ");
			paramValues.addValue("localityId", licenseSearchEntity.getLocality());
		}

		if (licenseSearchEntity.getOwnerName() != null && !licenseSearchEntity.getOwnerName().trim().isEmpty()) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append(" upper(ownerName) like :ownerName ");
			paramValues.addValue("ownerName", '%' + licenseSearchEntity.getOwnerName().toUpperCase() + '%');
		}

		if (licenseSearchEntity.getTradeTitle() != null && !licenseSearchEntity.getTradeTitle().trim().isEmpty()) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append(" upper(tradeTitle) like :tradeTitle ");
			paramValues.addValue("tradeTitle", '%' + licenseSearchEntity.getTradeTitle().toUpperCase() + '%');
		}

		if (licenseSearchEntity.getTradeType() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append(" tradeType = :tradeType ");
			paramValues.addValue("tradeType", licenseSearchEntity.getTradeType());
		}
		if (licenseSearchEntity.getTradeCategory() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append(" categoryId = :categoryId ");
			paramValues.addValue("categoryId", licenseSearchEntity.getTradeCategory());
		}

		if (licenseSearchEntity.getTradeSubCategory() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append(" subCategoryId = :subCategoryId ");
			paramValues.addValue("subCategoryId", licenseSearchEntity.getTradeSubCategory());
		}

		if (licenseSearchEntity.getStatus() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append(" status = :status ");
			paramValues.addValue("status", licenseSearchEntity.getStatus());
		}

		if (licenseSearchEntity.getPageSize() == null) {
			licenseSearchEntity.setPageSize(Integer.valueOf(propertiesManager.getPageSize()));
		}

		if (licenseSearchEntity.getPageNumber() == null) {
			licenseSearchEntity.setPageNumber(Integer.valueOf(propertiesManager.getPageNumber()));
		}

		if (licenseSearchEntity.getSort() == null || licenseSearchEntity.getSort().isEmpty()) {

			params.append("  ORDER BY licenseNumber ASC");
		} else if (licenseSearchEntity.getSort() != null && licenseSearchEntity.getSort().trim().isEmpty()) {

			params.append("  ORDER BY licenseNumber ASC");
		} else {

			params.append("  ORDER BY licenseNumber,tradeTitle,ownerName ASC");
		}

		params.append(" offset :offset ");
		paramValues.addValue("offset", ((licenseSearchEntity.getPageNumber() - 1) * licenseSearchEntity.getPageSize()));

		params.append(" limit :limit ");
		paramValues.addValue("limit", licenseSearchEntity.getPageSize());

		searchQuery = searchQuery.replace(":condition", " where " + params.toString());

		return searchQuery.toString();
	}

	public Long getLicenseApplicationId(Long licenseId) {

		Long applicationId = null;
		StringBuilder builder = new StringBuilder("select * from egtl_license_application where ");
		builder.append("licenseid = ");
		if (licenseId == null) {
			return null;
		}
		builder.append(licenseId.intValue());
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		List<Map<String, Object>> rows = namedParameterJdbcTemplate.queryForList(builder.toString(), parameter);
		if (rows != null && rows.size() > 0) {
			applicationId = Long.parseLong(rows.get(0).get("id").toString());
		}

		return applicationId;
	}
}