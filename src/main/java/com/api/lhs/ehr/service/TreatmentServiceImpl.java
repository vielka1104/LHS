package com.api.lhs.ehr.service;

import com.api.lhs.ehr.domain.entity.Treatment;
import com.api.lhs.ehr.domain.persistence.TreatmentRepository;
import com.api.lhs.ehr.domain.service.TreatmentService;
import com.api.lhs.ehr.resource.TreatmentResource;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class TreatmentServiceImpl implements TreatmentService {
    private final static String ENTITY = "Treatment";
    @Autowired
    private TreatmentRepository treatmentRepository;
    @Autowired
    private Validator validator;

    @Override
    public List<Treatment> getAll() {
        return treatmentRepository.findAll();
    }

    @Override
    public Treatment getById(Long treatmentId) {
        return treatmentRepository.findById(treatmentId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, treatmentId));
    }

    @Override
    public List<Treatment> getTreatmentsByName(String name) {
        return treatmentRepository.findByNameContains(name);
    }

    @Override
    public Treatment create(Treatment request) {
        try{
            return treatmentRepository.save(request);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while saving treatment");
        }
    }

    @Override
    public Treatment update(Long treatmentId, Treatment request) {
        try{
            return treatmentRepository.findById(treatmentId).map(treatment -> treatmentRepository.save(
                    treatment.withName(request.getName())
            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, treatmentId));
        }catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating treatment");
        }
    }

    @Override
    public Treatment delete(Long treatmentId) {
        return treatmentRepository.findById(treatmentId).map(treatment -> {
            treatmentRepository.delete(treatment);
            return treatment;
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, treatmentId));
    }
}
