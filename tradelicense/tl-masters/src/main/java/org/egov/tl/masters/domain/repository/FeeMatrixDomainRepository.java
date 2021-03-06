package org.egov.tl.masters.domain.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.tl.commons.web.contract.CategoryDetailSearch;
import org.egov.tl.commons.web.contract.RequestInfo;
import org.egov.tl.commons.web.requests.RequestInfoWrapper;
import org.egov.tl.commons.web.response.CategorySearchResponse;
import org.egov.tl.masters.contract.repository.FinancialRepository;
import org.egov.tl.masters.domain.enums.ApplicationTypeEnum;
import org.egov.tl.masters.domain.enums.BusinessNatureEnum;
import org.egov.tl.masters.domain.enums.FeeTypeEnum;
import org.egov.tl.masters.domain.model.FeeMatrix;
import org.egov.tl.masters.domain.model.FeeMatrixDetail;
import org.egov.tl.masters.domain.model.FeeMatrixSearch;
import org.egov.tl.masters.domain.model.FeeMatrixSearchCriteria;
import org.egov.tl.masters.domain.model.Pagination;
import org.egov.tl.masters.persistence.entity.FeeMatrixDetailEntity;
import org.egov.tl.masters.persistence.entity.FeeMatrixEntity;
import org.egov.tl.masters.persistence.entity.FeeMatrixSearchEntity;
import org.egov.tl.masters.persistence.repository.CategoryJdbcRepository;
import org.egov.tl.masters.persistence.repository.FeeMatrixJdbcRepository;
import org.egov.tradelicense.config.PropertiesManager;
import org.egov.tradelicense.domain.model.FinancialYearContract;
import org.egov.tradelicense.domain.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeeMatrixDomainRepository {

	@Autowired
	PropertiesManager propertiesManager;

	@Autowired
	FeeMatrixJdbcRepository feeMatrixJdbcRepository;

	@Autowired
	CategoryJdbcRepository categoryJdbcRepository;

	@Autowired
	FeeMatrixDetailDomainRepository feeMatrixDetailDomainRepository;

	@Autowired
	CategoryService categoryService;

	@Autowired
	FinancialRepository financialRepository;
	/*
	 * @Autowired FinancialYearContractRepository financilaYearWebRepo;
	 */

	/**
	 * 
	 * @param FeeMatrix
	 * @return void
	 * 
	 *         this API will call add API of method of FeeMatrixQueueRepository
	 *         to add the FeeMatrixV2Request as message with topic name
	 * 
	 *         this method will be called from feeMatrixService add method
	 */
	@Transactional
	public FeeMatrix add(FeeMatrix feeMatrix) {
		FeeMatrixEntity feeMatrixEntity = new FeeMatrixEntity();
		feeMatrixEntity = feeMatrixJdbcRepository.create(feeMatrixEntity.toEntity(feeMatrix));
		for (FeeMatrixDetail feeMatrixDetail : feeMatrix.getFeeMatrixDetails()) {
			feeMatrixDetailDomainRepository.add(new FeeMatrixDetailEntity().toEntity(feeMatrixDetail));
		}

		return feeMatrixEntity.toDomain();
	}

	/**
	 * 
	 * @param categoryId
	 * @return String CategoryName
	 * 
	 *         this will call the FeeMatrixJdbcRepository getCategory
	 */
	public String getCategoryName(Long categoryId) {

		return null;
	}

	/**
	 * 
	 * @param id
	 * @return boolean
	 * 
	 *         this API will call validateCategory method of jdbc repository
	 *         class and returns whatever it gets from that call
	 */
	public boolean validateCategory(Long id, Long parentId, String tenantId) {

		return categoryJdbcRepository.validateIdExistance(id, parentId, tenantId);
	}

	public boolean validateInputId(Long id, String tenantId) {
		return feeMatrixJdbcRepository.validateFeeMatrixByIdAndTenantID(id, tenantId);
	}

	public boolean checkUniquenessOfFeeMatrix(String tenantId, ApplicationTypeEnum applicationTypeEnum,
			FeeTypeEnum feeTypeEnum, BusinessNatureEnum businessNatureEnum, Long categoryId, Long subCategoryId,
			String financialYear) {
		FeeMatrixSearchEntity feeMatrixSearchEntity = new FeeMatrixSearchEntity();
		feeMatrixSearchEntity.setTenantId(tenantId);
		feeMatrixSearchEntity.setApplicationType(applicationTypeEnum == null ? null : applicationTypeEnum.toString());
		feeMatrixSearchEntity.setBusinessNature(businessNatureEnum == null ? null : businessNatureEnum.toString());
		feeMatrixSearchEntity.setFeeType(feeTypeEnum.toString());
		feeMatrixSearchEntity.setCategoryId(categoryId);
		feeMatrixSearchEntity.setSubCategoryId(subCategoryId);
		feeMatrixSearchEntity.setFinancialYear(financialYear);
		return feeMatrixJdbcRepository.checkWhetherFeeMatrixExistsWithGivenFieds(feeMatrixSearchEntity);
	}

	public boolean validateFeeMatrixDetails(Long uomFrom, Long uomTo) {

		return feeMatrixJdbcRepository.checkWhetherFeeMatrixExistsWithGivenUom(uomFrom, uomTo);
	}

	public Long getFeeMatrixNextSequence() {

		String id = feeMatrixJdbcRepository.getSequence(FeeMatrixEntity.SEQUENCE_NAME);
		return Long.valueOf(id);
	}

	public FeeMatrix getFeeMatrixForNextFinancialYear(FeeMatrixSearchCriteria domain) {

		ModelMapper modelMapper = new ModelMapper();
		FeeMatrixSearchEntity search = modelMapper.map(domain, FeeMatrixSearchEntity.class);
		Pagination<FeeMatrixEntity> feeMatrixEntities = feeMatrixJdbcRepository
				.getFeeMatrixForNextFinancialYear(search);

		List<FeeMatrix> feeMatrices = new ArrayList<>();
		for (FeeMatrixEntity feeMatrixEntity : feeMatrixEntities.getPagedData()) {

			feeMatrices.add(feeMatrixEntity.toDomain());
		}

		if (feeMatrices.size() > 0)
			return feeMatrices.get(0);
		else
			return null;
	}

	public FeeMatrix getFeeMatrixForPreviousFinancialYear(FeeMatrixSearchCriteria domain) {
		ModelMapper modelMapper = new ModelMapper();
		FeeMatrixSearchEntity search = modelMapper.map(domain, FeeMatrixSearchEntity.class);
		Pagination<FeeMatrixEntity> feeMatrixEntities = feeMatrixJdbcRepository
				.getFeeMatrixForPreviousFinancialYear(search);

		List<FeeMatrix> feeMatrices = new ArrayList<>();
		for (FeeMatrixEntity feeMatrixEntity : feeMatrixEntities.getPagedData()) {

			feeMatrices.add(feeMatrixEntity.toDomain());
		}

		if (feeMatrices.size() > 0)
			return feeMatrices.get(0);
		else
			return null;
	}

	public FeeMatrix update(FeeMatrix previousFeeMatrix) {
		FeeMatrixEntity feeMatrixEntity = new FeeMatrixEntity();
		feeMatrixEntity = feeMatrixJdbcRepository.update(feeMatrixEntity.toEntity(previousFeeMatrix));
		for (FeeMatrixDetail feeMatrixDetail : previousFeeMatrix.getFeeMatrixDetails()) {
			feeMatrixDetailDomainRepository.update(new FeeMatrixDetailEntity().toEntity(feeMatrixDetail));
		}
		return feeMatrixEntity.toDomain();
	}

	public List<FeeMatrixSearch> search(FeeMatrixSearchCriteria feeMatrixSearchCriteria, RequestInfo requestInfo) {
		ModelMapper modelMapper = new ModelMapper();
		FeeMatrixSearchEntity feeMatrixSearchEntity = modelMapper.map(feeMatrixSearchCriteria,
				FeeMatrixSearchEntity.class);
		List<FeeMatrixEntity> feeMatrixEntity = feeMatrixJdbcRepository.search(feeMatrixSearchEntity);

		if (feeMatrixSearchEntity.getFallBack()) {
			if (feeMatrixEntity.size() == 0) {
				int count = 0;
				while (count <= 2) {
					if (count == 0) {
						feeMatrixSearchEntity.setBusinessNature(null);
					} else if (count == 1) {
						feeMatrixSearchEntity.setApplicationType(null);
					} else {
						feeMatrixSearchEntity.setBusinessNature(null);
						feeMatrixSearchEntity.setApplicationType(null);
					}
					feeMatrixEntity = feeMatrixJdbcRepository.search(feeMatrixSearchEntity);
					if (feeMatrixEntity.size() > 0) {
						break;
					} else {

						count++;
					}
				}

			}
		}
		List<FeeMatrixSearch> feeMatrixSearchList = new ArrayList<FeeMatrixSearch>();
		Map<String, FinancialYearContract> finicialYearMap = new HashMap<String, FinancialYearContract>();
		Map<Long, CategorySearchResponse> categoryDetailsMap = new HashMap<Long, CategorySearchResponse>();

		for (FeeMatrixEntity feeMatrix : feeMatrixEntity) {

			FeeMatrixSearch feeMatrixSearch = new FeeMatrixEntity().toSearchDomain(feeMatrix);
			List<FeeMatrixDetail> feeMatrixDetails = getFeeMatrixDetailsByFeeMatrixId(feeMatrixSearch.getId());
			feeMatrixSearch.setFeeMatixDetails(feeMatrixDetails);
			CategorySearchResponse categoryResponse = null;
			if (categoryDetailsMap.get(feeMatrix.getSubCategoryId()) == null) {
				categoryResponse = getSubCategoryDetail(feeMatrix.getSubCategoryId(), feeMatrix.getTenantId(),
						feeMatrix.getFeeType(), requestInfo);
				categoryDetailsMap.put(feeMatrix.getSubCategoryId(), categoryResponse);
			} else {
				categoryResponse = categoryDetailsMap.get(feeMatrix.getSubCategoryId());
			}

			CategoryDetailSearch categoryDetail = categoryResponse.getCategories().get(0).getDetails().get(0);
			feeMatrixSearch.setUomId(categoryDetail.getUomId());
			String rateType = categoryDetail.getRateType() == null ? null : categoryDetail.getRateType().toString();
			feeMatrixSearch.setRateType(rateType);
			feeMatrixSearch.setCategoryName(categoryResponse.getCategories().get(0).getParentName());
			feeMatrixSearch.setSubCategoryName(categoryResponse.getCategories().get(0).getName());
			feeMatrixSearch.setUomName(categoryDetail.getUomName());
			FinancialYearContract financialYearContract = null;
			if (finicialYearMap.get(feeMatrix.getFinancialYear()) == null) {
				RequestInfoWrapper requestInfoWrapper = new RequestInfoWrapper();
				requestInfoWrapper.setRequestInfo(requestInfo);

				financialYearContract = financialRepository.findFinancialYearById(feeMatrix.getTenantId(),
						feeMatrix.getFinancialYear(), requestInfoWrapper);
				if (financialYearContract != null) {
					feeMatrixSearch.setFinancialYear(financialYearContract.getFinYearRange());
					finicialYearMap.put(feeMatrix.getFinancialYear(), financialYearContract);
				}
			} else {
				financialYearContract = finicialYearMap.get(feeMatrix.getFinancialYear());
				feeMatrixSearch.setFinancialYear(financialYearContract.getFinYearRange());
			}
			feeMatrixSearchList.add(feeMatrixSearch);
		}
		return feeMatrixSearchList;
	}

	public List<FeeMatrixDetail> getFeeMatrixDetailsByFeeMatrixId(Long feeMatrixId) {
		return feeMatrixDetailDomainRepository.getFeeMatrixDetailsByFeeMatrixId(feeMatrixId);
	}

	public CategorySearchResponse getSubCategoryDetail(Long subCategoryId, String tenantId, String feeType,
			RequestInfo requestInfo) {
		Integer[] ids = new Integer[1];
		ids[0] = subCategoryId.intValue();
		return categoryService.getCategoryMaster(requestInfo, tenantId, ids, null, null, null, null, null, null, null,
				feeType, null, null, null);
	}

	public FeeMatrix getFeeMatrixById(Long id, String tenantId) {
		FeeMatrixSearchEntity entity = new FeeMatrixSearchEntity();
		Integer[] ids = new Integer[1];
		ids[0] = id.intValue();

		entity.setIds(ids);
		entity.setTenantId(tenantId);
		List<FeeMatrixEntity> feematrixEntity = feeMatrixJdbcRepository.search(entity);
		if (feematrixEntity != null && feematrixEntity.size() > 0) {
			return feematrixEntity.get(0).toDomain();
		} else {
			return null;
		}
	}

}
