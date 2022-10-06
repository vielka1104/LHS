package com.api.lhs.patient.service;

import com.api.lhs.patient.domain.entity.Patient;
import com.api.lhs.patient.domain.persistence.PatientRepository;
import com.api.lhs.patient.domain.persistence.RenalDiseaseRepository;
import com.api.lhs.patient.domain.service.PatientService;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    private final static String ENTITY = "Patient";
    private final static String ENTITY2 = "RenalDisease";
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RenalDiseaseRepository renalDiseaseRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getById(Long patientId) {
        return patientRepository.findById(patientId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, patientId));
    }

    @Override
    public List<Patient> getByUserName(String username) {
        return patientRepository.findByUsernameContains(username);
    }

    @Override
    public Patient getByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    @Override
    public Patient getByDocumentNumber(String documentNumber) {
        return patientRepository.findByDocumentNumber(documentNumber);
    }

    @Override
    public List<Patient> getByNameAndLastName(String name, String lastName) {
        return patientRepository.findByNameAndLastnameContaining(name, lastName);
    }

    @Override
    public List<Patient> getByRenalDiseaseId(Long renalDiseaseId) {
        return patientRepository.findByRenalDiseaseId(renalDiseaseId);
    }

    @Override
    public Patient updateRenalDisease(Long patientId, Long renalDiseaseId) {
        try{
            var renalDisease = renalDiseaseRepository.findById(renalDiseaseId);
            if(renalDisease.isEmpty())
                throw new ResourceNotFoundException(ENTITY2, renalDiseaseId);

            Optional<Patient> patient = patientRepository.findById(patientId);
            if(patient.isEmpty())
                throw new ResourceNotFoundException(ENTITY, patientId);

            Patient finalPatient = patient.get();
            finalPatient.setRenalDisease(renalDisease.get());

            return patientRepository.save(finalPatient);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while saving patient");
        }
    }

    @Override
    public Patient create(Long renalDiseaseId, Patient request) {
        try{
            var renalDisease = renalDiseaseRepository.findById(renalDiseaseId);
            if(renalDisease.isEmpty())
                throw new ResourceNotFoundException(ENTITY2, renalDiseaseId);

            request.setRenalDisease(renalDisease.get());

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
                            .withDialysisMaterial(request.getDialysisMaterial())
                            .withDocumentNumber(request.getDocumentNumber())
                            .withBirthday(request.getBirthday())
                            .withGender(request.getGender())
                            .withEmail(request.getEmail())
                            .withPhone(request.getPhone())
                            .withUsername(request.getUsername())
                            .withPassword(request.getPassword())
                            .withHeight(request.getHeight())
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
