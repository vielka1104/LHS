package com.api.lhs.patient.service;

import com.api.lhs.patient.domain.entity.Prediction;
import com.api.lhs.patient.domain.persistence.PatientRepository;
import com.api.lhs.patient.domain.persistence.PredictionRepository;
import com.api.lhs.patient.domain.service.PredictionService;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class PredictionServiceImpl implements PredictionService {
    private final static String ENTITY = "Prediction";
    private final static String ENTITY2 = "Patient";

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PredictionRepository predictionRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<Prediction> getAll() {
        return predictionRepository.findAll();
    }

    @Override
    public Prediction getById(Long predictionId) {
        return predictionRepository.findById(predictionId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, predictionId));
    }

    @Override
    public Prediction getByPatientId(Long patientId) {
        return predictionRepository.findByPatientId(patientId);
    }

    @Override
    public Prediction create(Long patientId, Prediction request) {
        try{
            var patient = patientRepository.findById(patientId);
            if(patient.isEmpty())
                throw new ResourceNotFoundException(ENTITY2, patientId);

            request.setPatient(patient.get());

            return predictionRepository.save(request);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while saving prediction");
        }
    }

    @Override
    public Prediction update(Long predictionId, Prediction request) {
        try{
            return predictionRepository.findById(predictionId).map(prediction -> predictionRepository.save(
                    prediction.withYes(request.getYes())
                            .withNo(request.getNo())
                            .withOutcome(request.getOutcome())
            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, predictionId));
        }catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating prediction");
        }
    }

    @Override
    public Prediction delete(Long predictionId) {
        return predictionRepository.findById(predictionId).map(prediction -> {
            predictionRepository.delete(prediction);
            return prediction;
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, predictionId));
    }
}
