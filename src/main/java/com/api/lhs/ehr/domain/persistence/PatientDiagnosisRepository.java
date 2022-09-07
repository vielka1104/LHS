package com.api.lhs.ehr.domain.persistence;

import com.api.lhs.ehr.domain.entity.PatientDiagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientDiagnosisRepository extends JpaRepository<PatientDiagnosis, Long> {
    List<PatientDiagnosis> findByPatient_Id(Long patientId);
}
