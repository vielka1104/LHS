package com.innova.LHS.services.impl;

import com.innova.LHS.dtos.PatientDto;
import com.innova.LHS.entities.Patient;
import com.innova.LHS.enums.SexId;
import com.innova.LHS.exceptions.InternalServerErrorException;
import com.innova.LHS.exceptions.LHSException;
import com.innova.LHS.jsons.RegisterPatientRest;
import com.innova.LHS.repositories.PatientRepository;
import com.innova.LHS.services.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;
    public static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public PatientDto registerPatient(RegisterPatientRest registerPatientRest) throws LHSException {
        Patient patientEntity;
        Patient patient = new Patient();
        LocalDate date = LocalDate.parse(registerPatientRest.getBirth());
        patient.setName(registerPatientRest.getName());
        patient.setLastName(registerPatientRest.getLastName());
        patient.setBirth(date);
        patient.setSex(SexId.valueOf(registerPatientRest.getBirth()));
        try{
            patientEntity = patientRepository.save(patient);
        }catch (final Exception e){
            throw new InternalServerErrorException("Error! No se pudo registrar al paciente");
        }
        return modelMapper.map(patientEntity,PatientDto.class);
    }
}
