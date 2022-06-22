package com.innova.LHS.services;

import com.innova.LHS.dtos.MedicDto;
import com.innova.LHS.exceptions.LHSException;
import com.innova.LHS.jsons.RegisterMedicRest;

public interface MedicService {
    MedicDto registerMedic(RegisterMedicRest registerMedicRest ) throws LHSException;
}
