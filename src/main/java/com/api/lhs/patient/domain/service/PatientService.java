package com.api.lhs.patient.domain.service;

import com.api.lhs.patient.domain.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAll();
    Patient getById(Long patientId);
    Patient getByUserName(String username);
    List<Patient> getByNameAndLastName(String name, String lastName);
    Patient create(Patient patient);
    Patient update(Long patientId, Patient patient);
    Patient delete(Long patientId);
}
