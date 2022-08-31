package com.api.lhs.patient.service;

import com.api.lhs.patient.domain.entity.Patient;
import com.api.lhs.patient.domain.persistence.PatientRepository;
import com.api.lhs.patient.domain.service.PatientService;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final static String ENTITY = "Patient";

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getById(Long patientId) {
        return patientRepository.findById(patientId).orElseThrow(()-> new ResourceNotFoundException(ENTITY, patientId));
    }

    @Override
    public Patient getByUserName(String username) {
        return patientRepository.findByUsername(username);
    }

    @Override
    public Patient getByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    @Override
    public List<Patient> getByNameAndLastName(String name, String lastName) {
        return patientRepository.findByNameAndLastnameContaining(name, lastName);
    }

    @Override
    public Patient create(Patient request) {
        try{
            return patientRepository.save(request);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while saving patient");
        }
    }

    @Override
    public Patient update(Long patientId, Patient request) {
        try{
            return patientRepository.findById(patientId).map(patient -> patientRepository.save(
                    patient.withName(request.getName())
                            .withLastname(request.getLastname())
                            .withDocumentType(request.getDocumentType())
                            .withDocumentNumber(request.getDocumentNumber())
                            .withBirthday(request.getBirthday())
                            .withGender(request.getGender())
                            .withEmail(request.getEmail())
                            .withPhone(request.getPhone())
                            .withUsername(request.getUsername())
                            .withPassword(request.getPassword())
            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, patientId));
        }catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating patient");
        }
    }

    @Override
    public Patient delete(Long patientId) {
        return patientRepository.findById(patientId).map(patient -> {
            patientRepository.delete(patient);
            return patient;
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, patientId));
    }
}
