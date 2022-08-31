package com.api.lhs.staff.domain.persistence;

import com.api.lhs.staff.domain.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByUsername(String username);
}
