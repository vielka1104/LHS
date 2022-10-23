package com.api.lhs.patient.domain.persistence;

import com.api.lhs.patient.domain.entity.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredictionRepository extends JpaRepository<Prediction, Long> {
    Prediction findByPatientId(Long patientId);
}
