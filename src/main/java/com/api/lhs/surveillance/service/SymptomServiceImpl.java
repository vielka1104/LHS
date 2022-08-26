package com.api.lhs.surveillance.service;

import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.shared.exception.ResourceValidationException;
import com.api.lhs.surveillance.domain.entity.Symptom;
import com.api.lhs.surveillance.domain.persistence.NutritionRepository;
import com.api.lhs.surveillance.domain.persistence.SymptomRepository;
import com.api.lhs.surveillance.domain.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class SymptomServiceImpl implements SymptomService {
    private final static String ENTITY = "Symptom";

    @Autowired
    private SymptomRepository symptomRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<Symptom> getAll() {
        return symptomRepository.findAll();
    }

    @Override
    public Symptom getById(Long symptomId) {
        return symptomRepository.findById(symptomId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, symptomId));
    }

    @Override
    public Symptom create(Symptom request) {
        try{
            return symptomRepository.save(request);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while saving symptom");
        }
    }

    @Override
    public Symptom update(Long symptomId, Symptom request) {
        try{
            return symptomRepository.findById(symptomId).map(symptom -> symptomRepository.save(
                    symptom.withAppetite(request.getAppetite())
                            .withPain(request.getPain())
                            .withWeightVariation(request.getWeightVariation())
                            .withOther(request.getOther())
            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, symptomId));
        }catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating symptom");
        }
    }

    @Override
    public Symptom delete(Long symptomId) {
        return symptomRepository.findById(symptomId).map(symptom -> {
            symptomRepository.delete(symptom);
            return symptom;
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, symptomId));
    }
}
