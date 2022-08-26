package com.api.lhs.surveillance.domain.persistence;

import com.api.lhs.surveillance.domain.entity.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionRepository extends JpaRepository<Nutrition, Long> {
}
