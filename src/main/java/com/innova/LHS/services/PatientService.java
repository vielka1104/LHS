package com.innova.LHS.services;

import com.innova.LHS.dtos.PatientDto;
import com.innova.LHS.exceptions.LHSException;
import com.innova.LHS.jsons.RegisterPatientRest;

public interface PatientService {
     PatientDto registerPatient(RegisterPatientRest registerPatientRest ) throws LHSException;
}
