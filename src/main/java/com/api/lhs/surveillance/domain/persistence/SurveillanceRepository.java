package com.api.lhs.surveillance.domain.persistence;

import com.api.lhs.surveillance.domain.entity.Surveillance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveillanceRepository extends JpaRepository<Surveillance, Long> {
    List<Surveillance> findByPatientId(Long patientId);
}
