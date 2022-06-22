package com.innova.LHS.services;

import com.innova.LHS.dtos.PatientDto;
import com.innova.LHS.dtos.StaffDto;
import com.innova.LHS.exceptions.LHSException;
import com.innova.LHS.jsons.RegisterPatientRest;
import com.innova.LHS.jsons.RegisterStaffRest;

public interface StaffService {
    StaffDto registerStaff(RegisterStaffRest registerStaffRest ) throws LHSException;
}
