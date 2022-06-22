package com.innova.LHS.controllers;

import com.innova.LHS.dtos.MedicDto;
import com.innova.LHS.exceptions.LHSException;
import com.innova.LHS.jsons.RegisterMedicRest;
import com.innova.LHS.responses.LHSResponse;
import com.innova.LHS.services.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/medic"+"/v1")
public class MedicController {

    @Autowired
    MedicService medicService;

    private LHSResponse<MedicDto> registerMedic(@RequestBody @Valid RegisterMedicRest registerMedicRest) throws LHSException{
        return new LHSResponse<>(200,String.valueOf(HttpStatus.OK),"OK",medicService.registerMedic(registerMedicRest));
    }
}
