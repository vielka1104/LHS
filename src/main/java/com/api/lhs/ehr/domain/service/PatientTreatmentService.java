package com.api.lhs.ehr.domain.service;

import com.api.lhs.ehr.domain.entity.PatientTreatment;

import java.util.List;

public interface PatientTreatmentService {
    List<PatientTreatment> getAll();
    PatientTreatment getById(Long patientTreatmentId);
    List<PatientTreatment> getByPatientId(Long patientId);
    List<PatientTreatment> getByTreatmentId(Long treatmentId);
    PatientTreatment create(PatientTreatment request, Long patientId, Long treatmentId, Long medicineId);
    PatientTreatment update(Long patientTreatmentId, PatientTreatment request);
    PatientTreatment delete(Long patientTreatmentId);
}
