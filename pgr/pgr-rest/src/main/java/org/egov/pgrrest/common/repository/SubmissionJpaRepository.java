package org.egov.pgrrest.common.repository;

import org.egov.pgrrest.common.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionJpaRepository extends JpaRepository<Submission, String> {
    Submission findByIdAndTenantId(String crn, String TenantId);
}