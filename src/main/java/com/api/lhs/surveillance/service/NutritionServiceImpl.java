package com.api.lhs.surveillance.service;

import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.shared.exception.ResourceValidationException;
import com.api.lhs.surveillance.domain.entity.Nutrition;
import com.api.lhs.surveillance.domain.persistence.NutritionRepository;
import com.api.lhs.surveillance.domain.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class NutritionServiceImpl implements NutritionService {
    private final static String ENTITY = "Nutrition";

    @Autowired
    private NutritionRepository nutritionRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<Nutrition> getAll() {
        return nutritionRepository.findAll();
    }

    @Override
    public Nutrition getById(Long nutritionId) {
        return nutritionRepository.findById(nutritionId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, nutritionId));
    }

    @Override
    public Nutrition create(Nutrition request) {
        try{
            return nutritionRepository.save(request);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while saving nutrition");
        }
    }

    @Override
    public Nutrition update(Long nutritionId, Nutrition request) {
        try{
            return nutritionRepository.findById(nutritionId).map(nutrition -> nutritionRepository.save(
                    nutrition.withPlan(request.getPlan())
            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, nutritionId));
        }catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating nutrition");
        }
    }

    @Override
    public Nutrition delete(Long nutritionId) {
        return nutritionRepository.findById(nutritionId).map(nutrition -> {
            nutritionRepository.delete(nutrition);
            return nutrition;
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, nutritionId));
    }
}
