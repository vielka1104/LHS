package com.api.lhs.surveillance.domain.persistence;

import com.api.lhs.surveillance.domain.entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Long> {
}
