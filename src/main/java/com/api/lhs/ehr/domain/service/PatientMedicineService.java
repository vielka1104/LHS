package com.api.lhs.ehr.domain.service;

import com.api.lhs.ehr.domain.entity.PatientMedicine;

import java.util.List;

public interface PatientMedicineService {
    List<PatientMedicine> getAll();
    PatientMedicine getById(Long patientMedicineId);
    List<PatientMedicine> getByPatientId(Long patientId);
    List<PatientMedicine> getByMedicineId(Long medicineId);
    PatientMedicine create(PatientMedicine request, Long patientId, Long medicineId);
    PatientMedicine update(Long patientMedicineId, PatientMedicine request);
    PatientMedicine delete(Long patientMedicineId);
}
