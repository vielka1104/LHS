package com.innova.LHS.controllers;

import com.innova.LHS.dtos.PatientDto;
import com.innova.LHS.exceptions.LHSException;
import com.innova.LHS.jsons.RegisterPatientRest;
import com.innova.LHS.responses.LHSResponse;
import com.innova.LHS.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.http.HttpClient;

@RestController
@RequestMapping(path = "/patient"+"/v1")
public class PatientController {
    @Autowired
    PatientService patientService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/registerPatient")
    private LHSResponse<PatientDto> registerPatient (@RequestBody @Valid RegisterPatientRest registerPatientRest) throws LHSException {
        return new LHSResponse<>(200,String.valueOf(HttpStatus.OK),"OK",patientService.registerPatient(registerPatientRest));
    }
}
