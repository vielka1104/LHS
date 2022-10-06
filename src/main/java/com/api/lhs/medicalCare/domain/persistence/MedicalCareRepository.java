package com.api.lhs.medicalCare.domain.persistence;

import com.api.lhs.medicalCare.domain.entity.MedicalCare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalCareRepository extends JpaRepository<MedicalCare, Long> {
    List<MedicalCare> findByPatientId(Long patientId);
}
