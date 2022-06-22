package com.innova.LHS.repositories;

import com.innova.LHS.entities.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicRepository extends JpaRepository<Medic,Long> {
    Optional<Medic> findById(Long id);
}
