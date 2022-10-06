package com.api.lhs.ehr.service;

import com.api.lhs.ehr.domain.entity.PatientMedicine;
import com.api.lhs.ehr.domain.persistence.MedicineRepository;
import com.api.lhs.ehr.domain.persistence.PatientMedicineRepository;
import com.api.lhs.ehr.domain.service.PatientMedicineService;
import com.api.lhs.patient.domain.persistence.PatientRepository;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientMedicineServiceImpl implements PatientMedicineService {
    private final static String ENTITY = "PatientMedicine";
    private final static String ENTITY2 = "Patient";
    private final static String ENTITY3 = "Medicine";

    @Autowired
    private PatientMedicineRepository patientMedicineRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public List<PatientMedicine> getAll() {
        return patientMedicineRepository.findAll();
    }

    @Override
    public PatientMedicine getById(Long patientMedicineId) {
        return patientMedicineRepository.findById(patientMedicineId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, patientMedicineId));
    }

    @Override
    public List<PatientMedicine> getByPatientId(Long patientId) {
        return patientMedicineRepository.findByPatientId(patientId);
    }

    @Override
    public List<PatientMedicine> getByMedicineId(Long medicineId) {
        return patientMedicineRepository.findByMedicineId(medicineId);
    }

    @Override
    public PatientMedicine create(PatientMedicine request, Long patientId, Long medicineId) {
        var patient = patientRepository.findById(patientId);
        if(patient.isEmpty())
            throw new ResourceNotFoundException(ENTITY2, patientId);

        var medicine = medicineRepository.findById(medicineId);
        if(medicine.isEmpty())
            throw new ResourceNotFoundException(ENTITY2, medicineId);

        request.setPatient(patient.get());
        request.setMedicine(medicine.get());

        return patientMedicineRepository.save(request);
    }

    @Override
    public PatientMedicine update(Long patientMedicineId, PatientMedicine request) {
        return patientMedicineRepository.findById(patientMedicineId)
                .map(patientMedicine -> patientMedicineRepository.save(
                        patientMedicine.withQuantity(request.getQuantity())
                                .withFrequency(request.getFrequency())
                )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, patientMedicineId));
    }

    @Override
    public PatientMedicine delete(Long patientMedicineId) {
        return patientMedicineRepository.findById(patientMedicineId)
                .map(patientMedicine -> {
                    patientMedicineRepository.delete(patientMedicine);
                    return patientMedicine;
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, patientMedicineId));
    }
}
