package com.api.lhs.ehr.service;

import com.api.lhs.ehr.domain.entity.Diagnosis;
import com.api.lhs.ehr.domain.persistence.DiagnosisRepository;
import com.api.lhs.ehr.domain.service.DiagnosisService;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {
    private final static String ENTITY = "Diagnosis";
    @Autowired
    private DiagnosisRepository diagnosisRepository;
    @Autowired
    private Validator validator;

    @Override
    public List<Diagnosis> getAll() {
        return diagnosisRepository.findAll();
    }

    @Override
    public Diagnosis getById(Long diagnosisId) {
        return diagnosisRepository.findById(diagnosisId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, diagnosisId));
    }

    @Override
    public List<Diagnosis> getDiagnosisByName(String name) {
        return diagnosisRepository.findByNameContains(name);
    }

    @Override
    public Diagnosis create(Diagnosis request) {
        try{
            return diagnosisRepository.save(request);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while saving diagnosis");
        }
    }

    @Override
    public Diagnosis update(Long diagnosisId, Diagnosis request) {
        try{
            return diagnosisRepository.findById(diagnosisId).map(diagnosis -> diagnosisRepository.save(
                    diagnosis.withName(request.getName())
                            .withDescription(request.getDescription())
            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, diagnosisId));
        }catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating diagnosis");
        }
    }

    @Override
    public Diagnosis delete(Long diagnosisId) {
        return diagnosisRepository.findById(diagnosisId).map(diagnosis -> {
            diagnosisRepository.delete(diagnosis);
            return diagnosis;
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, diagnosisId));
    }
}
