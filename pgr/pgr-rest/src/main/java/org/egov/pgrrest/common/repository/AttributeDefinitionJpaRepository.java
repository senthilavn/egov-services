package org.egov.pgrrest.common.repository;

import org.egov.pgrrest.common.entity.AttributeDefinition;
import org.egov.pgrrest.common.entity.AttributeDefinitionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeDefinitionJpaRepository extends JpaRepository<AttributeDefinition, AttributeDefinitionKey> {

    @Query("select a from AttributeDefinition a where a.id.serviceCode = :serviceCode and a.id.tenantId = :tenantId")
    List<AttributeDefinition> findByServiceCodeAndTenantId(@Param("serviceCode") String serviceCode,
                                                           @Param("tenantId") String tenantId);
}