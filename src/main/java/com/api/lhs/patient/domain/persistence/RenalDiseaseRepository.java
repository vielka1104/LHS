package com.api.lhs.patient.domain.persistence;

import com.api.lhs.patient.domain.entity.RenalDisease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RenalDiseaseRepository extends JpaRepository<RenalDisease, Long> {
    RenalDisease findByName(String name);
}
