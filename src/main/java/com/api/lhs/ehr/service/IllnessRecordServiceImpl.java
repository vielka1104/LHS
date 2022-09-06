package com.api.lhs.ehr.service;

import com.api.lhs.ehr.domain.entity.IllnessRecord;
import com.api.lhs.ehr.domain.persistence.IllnessRecordRepository;
import com.api.lhs.ehr.domain.service.IllnessRecordService;
import com.api.lhs.patient.domain.persistence.PatientRepository;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class IllnessRecordServiceImpl implements IllnessRecordService {
    private final static String ENTITY = "IllnessRecord";
    private final static String ENTITY2 = "Patient";
    @Autowired
    private IllnessRecordRepository illnessRecordRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private Validator validator;

    @Override
    public List<IllnessRecord> getAll() {
        return illnessRecordRepository.findAll();
    }

    @Override
    public IllnessRecord getById(Long illnessRecordId) {
        return illnessRecordRepository.findById(illnessRecordId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, illnessRecordId));
    }

    @Override
    public List<IllnessRecord> getIllnessRecordsByPatientId(Long patientId) {
        return illnessRecordRepository.findByPatientId(patientId);
    }

    @Override
    public List<IllnessRecord> getIllnessRecordsByPatientIdAndName(Long patientId, String name) {
        return illnessRecordRepository.findByPatientIdAndIllnessContains(patientId,name);
    }

    @Override
    public IllnessRecord create(IllnessRecord request, Long patientId) {
        try{
            var patient = patientRepository.findById(patientId);
            if(patient.isEmpty())
                throw new ResourceNotFoundException(ENTITY2, patientId);

            request.setPatient(patient.get());

            return illnessRecordRepository.save(request);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while saving illness record");
        }
    }

    @Override
    public IllnessRecord update(Long illnessRecordId, IllnessRecord request) {
        try{
            return illnessRecordRepository.findById(illnessRecordId).map(illnessRecord -> illnessRecordRepository.save(
                    illnessRecord.withIllness(request.getIllness())
                            .withDescription(request.getDescription())
                            .withDate(request.getDate())
            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, illnessRecordId));
        }catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating illness record");
        }
    }

    @Override
    public IllnessRecord delete(Long illnessRecordId) {
        return illnessRecordRepository.findById(illnessRecordId).map(illnessRecord -> {
            illnessRecordRepository.delete(illnessRecord);
            return illnessRecord;
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, illnessRecordId));
    }
}
