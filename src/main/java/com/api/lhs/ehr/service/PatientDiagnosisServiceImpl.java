package com.api.lhs.ehr.service;

import com.api.lhs.ehr.domain.entity.PatientDiagnosis;
import com.api.lhs.ehr.domain.persistence.DiagnosisRepository;
import com.api.lhs.ehr.domain.persistence.PatientDiagnosisRepository;
import com.api.lhs.ehr.domain.service.PatientDiagnosisService;
import com.api.lhs.patient.domain.persistence.PatientRepository;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class PatientDiagnosisServiceImpl implements PatientDiagnosisService {
    private final static String ENTITY = "PatientDiagnosis";
    private final static String ENTITY2 = "Patient";
    private final static String ENTITY3 = "Diagnosis";
    @Autowired
    private PatientDiagnosisRepository patientDiagnosisRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<PatientDiagnosis> getAll() {
        return patientDiagnosisRepository.findAll();
    }

    @Override
    public PatientDiagnosis getById(Long patientDiagnosisId) {
        return patientDiagnosisRepository.findById(patientDiagnosisId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, patientDiagnosisId));
    }

    @Override
    public List<PatientDiagnosis> getByPatientId(Long patientId) {
        return patientDiagnosisRepository.findByPatient_Id(patientId);
    }

    @Override
    public PatientDiagnosis create(PatientDiagnosis request, Long patientId, Long diagnosisId) {
        var patient = patientRepository.findById(patientId);
        if(patient.isEmpty())
            throw new ResourceNotFoundException(ENTITY2, patientId);

        var diagnosis = diagnosisRepository.findById(diagnosisId);
        if(diagnosis.isEmpty())
            throw new ResourceNotFoundException(ENTITY3, diagnosisId);

        request.setPatient(patient.get());
        request.setDiagnosis(diagnosis.get());

        return patientDiagnosisRepository.save(request);
    }

    @Override
    public PatientDiagnosis update(Long patientDiagnosisId, PatientDiagnosis request) {
        return patientDiagnosisRepository.findById(patientDiagnosisId)
                .map(patientDiagnosis -> patientDiagnosisRepository.save(
                        patientDiagnosis.withStartDate(request.getStartDate())
                                .withEndDate(request.getEndDate())
                )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, patientDiagnosisId));
    }

    @Override
    public PatientDiagnosis delete(Long patientDiagnosisId) {
        return patientDiagnosisRepository.findById(patientDiagnosisId)
                .map(patientDiagnosis -> {
                    patientDiagnosisRepository.delete(patientDiagnosis);
                    return patientDiagnosis;
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, patientDiagnosisId));
    }
}
