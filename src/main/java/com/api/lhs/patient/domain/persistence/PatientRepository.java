package com.api.lhs.patient.domain.persistence;

import com.api.lhs.patient.domain.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByUsername(String username);
    List<Patient> findByNameAndLastnameContaining(String name, String lastName);

}