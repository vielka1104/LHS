package com.api.lhs.doctor.domain.persistence;

import com.api.lhs.doctor.domain.entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {
    List<Shift> findByNameContaining(String name);
}
