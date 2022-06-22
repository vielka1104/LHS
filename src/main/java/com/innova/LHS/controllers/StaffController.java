package com.innova.LHS.controllers;

import com.innova.LHS.dtos.StaffDto;
import com.innova.LHS.exceptions.LHSException;
import com.innova.LHS.jsons.RegisterStaffRest;
import com.innova.LHS.responses.LHSResponse;
import com.innova.LHS.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/staff"+"/v1")
public class StaffController {

    @Autowired
    StaffService staffService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/registerStaff")
    private LHSResponse<StaffDto> registerStaff (@RequestBody @Valid RegisterStaffRest registerStaffRest) throws LHSException{
        return new LHSResponse<>(200,String.valueOf(HttpStatus.OK),"OK",staffService.registerStaff(registerStaffRest));
    }
}
