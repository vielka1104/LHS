package com.api.lhs.ehr.domain.persistence;

import com.api.lhs.ehr.domain.entity.IllnessRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IllnessRecordRepository extends JpaRepository<IllnessRecord, Long> {
    List<IllnessRecord> findByPatientId(Long patientId);
    List<IllnessRecord> findByPatientIdAndIllnessContains(Long patientId, String illness);
}
