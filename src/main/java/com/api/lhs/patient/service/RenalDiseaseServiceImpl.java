package com.api.lhs.patient.service;

import com.api.lhs.patient.domain.entity.RenalDisease;
import com.api.lhs.patient.domain.persistence.RenalDiseaseRepository;
import com.api.lhs.patient.domain.service.RenalDiseaseService;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class RenalDiseaseServiceImpl implements RenalDiseaseService {
    private final static String ENTITY = "RenalDisease";
    @Autowired
    private RenalDiseaseRepository renalDiseaseRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<RenalDisease> getAll() {
        return renalDiseaseRepository.findAll();
    }

    @Override
    public RenalDisease getById(Long renalDiseaseId) {
        return renalDiseaseRepository.findById(renalDiseaseId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, renalDiseaseId));
    }

    @Override
    public RenalDisease getByName(String name) {
        return renalDiseaseRepository.findByName(name);
    }

    @Override
    public RenalDisease create(RenalDisease request) {
        try{
            return renalDiseaseRepository.save(request);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while saving renal disease");
        }
    }

    @Override
    public RenalDisease update(Long renalDiseaseId, RenalDisease request) {
        try{
            return renalDiseaseRepository.findById(renalDiseaseId).map(renalDisease -> renalDiseaseRepository.save(
                    renalDisease.withName(request.getName())
                            .withDescription(request.getDescription())
            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, renalDiseaseId));
        }catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating renal disease");
        }
    }

    @Override
    public RenalDisease delete(Long renalDiseaseId) {
        return renalDiseaseRepository.findById(renalDiseaseId).map(renalDisease -> {
            renalDiseaseRepository.delete(renalDisease);
            return renalDisease;
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, renalDiseaseId));
    }
}
