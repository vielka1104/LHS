package com.api.lhs.ehr.domain.persistence;

import com.api.lhs.ehr.domain.entity.PatientTreatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientTreatmentRepository extends JpaRepository<PatientTreatment, Long> {
    List<PatientTreatment> findByPatient_Id(Long patientId);
    List<PatientTreatment> findByTreatment_Id(Long treatmentId);
}
