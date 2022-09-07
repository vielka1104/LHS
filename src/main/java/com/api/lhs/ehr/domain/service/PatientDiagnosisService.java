package com.api.lhs.ehr.domain.service;

import com.api.lhs.ehr.domain.entity.PatientDiagnosis;

import java.util.List;

public interface PatientDiagnosisService {
    List<PatientDiagnosis> getAll();
    PatientDiagnosis getById(Long patientDiagnosisId);
    List<PatientDiagnosis> getByPatientId(Long patientId);
    List<PatientDiagnosis> getByDiagnosisId(Long diagnosisId);
    PatientDiagnosis create(PatientDiagnosis request, Long patientId, Long diagnosisId);
    PatientDiagnosis update(Long patientDiagnosisId, PatientDiagnosis request);
    PatientDiagnosis delete(Long patientDiagnosisId);
}
