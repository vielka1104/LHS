package com.api.lhs.ehr.service;

import com.api.lhs.ehr.domain.entity.PatientTreatment;
import com.api.lhs.ehr.domain.persistence.MedicineRepository;
import com.api.lhs.ehr.domain.persistence.PatientTreatmentRepository;
import com.api.lhs.ehr.domain.persistence.TreatmentRepository;
import com.api.lhs.ehr.domain.service.PatientTreatmentService;
import com.api.lhs.patient.domain.persistence.PatientRepository;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientTreatmentServiceImpl implements PatientTreatmentService {
    private final static String ENTITY = "PatientTreatment";
    private final static String ENTITY2 = "Patient";
    private final static String ENTITY3 = "Treatment";

    @Autowired
    private PatientTreatmentRepository patientTreatmentRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private TreatmentRepository treatmentRepository;

    @Override
    public List<PatientTreatment> getAll() {
        return patientTreatmentRepository.findAll();
    }

    @Override
    public PatientTreatment getById(Long patientTreatmentId) {
        return patientTreatmentRepository.findById(patientTreatmentId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, patientTreatmentId));
    }

    @Override
    public List<PatientTreatment> getByPatientId(Long patientId) {
        return patientTreatmentRepository.findByPatient_Id(patientId);
    }

    @Override
    public List<PatientTreatment> getByTreatmentId(Long treatmentId) {
        return patientTreatmentRepository.findByTreatment_Id(treatmentId);
    }

    @Override
    public PatientTreatment create(PatientTreatment request, Long patientId, Long treatmentId) {
        var patient = patientRepository.findById(patientId);
        if(patient.isEmpty())
            throw new ResourceNotFoundException(ENTITY2, patientId);

        var treatment = treatmentRepository.findById(treatmentId);
        if(treatment.isEmpty())
            throw new ResourceNotFoundException(ENTITY3, treatmentId);

        request.setPatient(patient.get());
        request.setTreatment(treatment.get());
        
        return patientTreatmentRepository.save(request);
    }

    @Override
    public PatientTreatment update(Long patientTreatmentId, PatientTreatment request) {
        return patientTreatmentRepository.findById(patientTreatmentId)
                .map(patientTreatment -> patientTreatmentRepository.save(request))
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, patientTreatmentId));
    }

    @Override
    public PatientTreatment delete(Long patientTreatmentId) {
        return patientTreatmentRepository.findById(patientTreatmentId)
                .map(patientTreatment -> {
                    patientTreatmentRepository.delete(patientTreatment);
                    return patientTreatment;
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, patientTreatmentId));
    }
}
