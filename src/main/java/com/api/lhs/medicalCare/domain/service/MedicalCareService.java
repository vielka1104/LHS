package com.api.lhs.medicalCare.domain.service;

import com.api.lhs.medicalCare.domain.entity.MedicalCare;

import java.util.List;

public interface MedicalCareService {
    List<MedicalCare> getAll();
    MedicalCare getById(Long medicalCareId);
    List<MedicalCare> getByPatientId(Long patientId);
    MedicalCare create(MedicalCare request, Long patientId);
    MedicalCare update(Long medicalCareId, MedicalCare request);
    MedicalCare delete(Long medicalCareId);
}
