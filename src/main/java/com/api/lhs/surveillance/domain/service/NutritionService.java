package com.api.lhs.surveillance.domain.service;

import com.api.lhs.surveillance.domain.entity.Nutrition;

import java.util.List;

public interface NutritionService {
    List<Nutrition> getAll();
    Nutrition getById(Long nutritionId);
    Nutrition create(Nutrition request);
    Nutrition update(Long nutritionId, Nutrition request);
    Nutrition delete(Long nutritionId);
}
