package com.api.lhs.ehr.domain.persistence;

import com.api.lhs.ehr.domain.entity.PatientMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientMedicineRepository extends JpaRepository<PatientMedicine, Long> {
    List<PatientMedicine> findByPatientId(Long patientId);
    List<PatientMedicine> findByMedicineId(Long diagnosisId);
}
