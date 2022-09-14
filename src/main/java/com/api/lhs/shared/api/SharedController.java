package com.api.lhs.shared.api;

import com.api.lhs.doctor.domain.entity.Doctor;
import com.api.lhs.doctor.domain.service.DoctorService;
import com.api.lhs.doctor.mapping.DoctorMapper;
import com.api.lhs.patient.domain.entity.Patient;
import com.api.lhs.patient.domain.service.PatientService;
import com.api.lhs.patient.mapping.PatientMapper;
import com.api.lhs.shared.domain.service.SharedService;
import com.api.lhs.shared.resource.LoginResource;
import com.api.lhs.staff.domain.entity.Staff;
import com.api.lhs.staff.domain.service.StaffService;
import com.api.lhs.staff.mapping.StaffMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Shared")
@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class SharedController {
    @Autowired
    private SharedService sharedService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private StaffService staffService;

    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private StaffMapper staffMapper;

    @Operation(summary = "Login", description = "Login")
    @PostMapping("login")
    public Object createDoctor(@RequestBody LoginResource model){
        var user = sharedService.login(model.getUsername(), model.getPassword());
        if(user instanceof Patient){
            return patientMapper.toResource(patientService.getByUserName(model.getUsername()));
        }

        if(user instanceof Doctor){
            return doctorMapper.toResource(doctorService.getByUserName(model.getUsername()));
        }

        if(user instanceof Staff){
            return staffMapper.toResource(staffService.getByUserName(model.getUsername()));
        }

        return null;
    }
}
