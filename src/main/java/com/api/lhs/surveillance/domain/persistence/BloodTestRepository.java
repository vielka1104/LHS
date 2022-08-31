package com.api.lhs.surveillance.domain.persistence;

import com.api.lhs.surveillance.domain.entity.BloodTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodTestRepository extends JpaRepository<BloodTest, Long> {
}
