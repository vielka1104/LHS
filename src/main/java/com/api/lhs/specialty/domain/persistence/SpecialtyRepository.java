package com.api.lhs.specialty.domain.persistence;

import com.api.lhs.specialty.domain.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
    List<Specialty> findSpecialtiesByNameContains(String name);
}
