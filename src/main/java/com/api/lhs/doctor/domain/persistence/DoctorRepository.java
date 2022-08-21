package com.api.lhs.doctor.domain.persistence;

import com.api.lhs.doctor.domain.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByUsername(String username);
    Doctor findByEmail(String email);
    List<Doctor> findByNameAndLastnameContaining(String name, String lastName);
}
