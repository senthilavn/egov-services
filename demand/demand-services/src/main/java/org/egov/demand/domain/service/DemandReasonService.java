package org.egov.demand.domain.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.egov.demand.persistence.entity.EgDemandReason;
import org.egov.demand.persistence.repository.DemandReasonRepository;
import org.egov.demand.web.contract.DemandReasonCriteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandReasonService {
	@Autowired
	private DemandReasonRepository demandReasonRepository;
	@PersistenceContext
	private EntityManager entityManager;

	public EgDemandReason findByCodeInstModule(String demandReasonCode, String instDescription, String moduleName,
			String tenantId) {
		return demandReasonRepository.findByCodeInstModule(demandReasonCode, instDescription, moduleName, tenantId);
	}

	public List<EgDemandReason> search(DemandReasonCriteria demandReasonCriteria) {
		StringBuilder queryStr = new StringBuilder();
		queryStr.append("from EgDemandReason dr where dr.tenantId=:tenantId");
		if (!demandReasonCriteria.getModuleName().isEmpty()) {
			queryStr.append(" and dr.egInstallmentMaster.module=:moduleName");
		}
		if (!demandReasonCriteria.getTaxCategory().isEmpty()) {
			queryStr.append(" and dr.egReasonCategory.code=:reasonCategory");
		}
		if (!demandReasonCriteria.getTaxReason().isEmpty()) {
			queryStr.append(" and dr.egDemandReasonMaster.code=:taxReason");
		}
		final Query query = entityManager.unwrap(Session.class).createQuery(queryStr.toString());
		query.setString("tenantId", demandReasonCriteria.getTenantId());
		if (!demandReasonCriteria.getModuleName().isEmpty()) {
			query.setString("moduleName", demandReasonCriteria.getModuleName());
		}
		if (!demandReasonCriteria.getTaxCategory().isEmpty()) {
			query.setString("reasonCategory", demandReasonCriteria.getTaxCategory());
		}
		if (!demandReasonCriteria.getTaxReason().isEmpty()) {
			query.setString("taxReason", demandReasonCriteria.getTaxReason());
		}
		return (List<EgDemandReason>) query.list();
	}
}
