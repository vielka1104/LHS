package com.api.lhs.patient.domain.service;

import com.api.lhs.patient.domain.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAll();
    Patient getById(Long patientId);
    List<Patient> getByUserName(String username);
    Patient getByEmail(String email);
    Patient getByDocumentNumber(String documentNumber);
    List<Patient> getByNameAndLastName(String name, String lastName);
    List<Patient> getByRenalDiseaseId(Long renalDiseaseId);
    Patient updateRenalDisease(Long patientId, Long renalDiseaseId);
    Patient create(Long renalDiseaseId, Patient patient);
    Patient update(Long patientId, Patient patient);
    Patient delete(Long patientId);
}
