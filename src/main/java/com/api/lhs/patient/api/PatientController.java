package com.api.lhs.patient.api;

import com.api.lhs.patient.domain.service.PatientService;
import com.api.lhs.patient.mapping.PatientMapper;
import com.api.lhs.patient.resource.CreatePatientResource;
import com.api.lhs.patient.resource.PatientResource;
import com.api.lhs.patient.resource.UpdatePatientResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Patient")
@RestController
@RequestMapping("api/v1/patients")
@CrossOrigin
public class PatientController {
    @Autowired
    private PatientService patientService;
    
    @Autowired
    private PatientMapper patientMapper;

    @Operation(summary = "Get All Patients", description = "Get All Patients")
    @GetMapping
    public List<PatientResource> getAllPatients(){
        return patientMapper.toResource(patientService.getAll());
    }

    @Operation(summary = "Get Patient by Id", description = "Get Patient by Id")
    @GetMapping("{patientId}")
    public PatientResource getPatientById(@PathVariable Long patientId){
        return patientMapper.toResource(patientService.getById(patientId));
    }

    @Operation(summary = "Get Patient by Username", description = "Get Patient by Username")
    @GetMapping("username/{username}")
    public PatientResource getPatientByUserName(@PathVariable String username){
        return patientMapper.toResource(patientService.getByUserName(username));
    }

    @Operation(summary = "Get Patient by Complete Name", description = "Get Patient by Complete Name")
    @GetMapping("name/{name}/lastName/{lastName}")
    public List<PatientResource> getPatientByFirstNameAndLastName(@PathVariable String name, @PathVariable String lastName){
        return patientMapper.toResource(patientService.getByNameAndLastName(name, lastName));
    }

    @Operation(summary = "Create New Patient", description = "Create New Patient")
    @PostMapping
    public PatientResource createPatient(@RequestBody CreatePatientResource model){
        return patientMapper.toResource(patientService.create(patientMapper.toModel(model)));
    }

    @Operation(summary = "Update Patient", description = "Update Patient")
    @PutMapping("{patientId}")
    public PatientResource updatePatient(@PathVariable Long patientId, @RequestBody UpdatePatientResource model){
        return patientMapper.toResource(patientService.update(patientId, patientMapper.toModel(model)));
    }

    @Operation(summary = "Delete Patient", description = "Delete Patient")
    @DeleteMapping("{patientId}")
    public void deletePatient(@PathVariable Long patientId){
        patientService.delete(patientId);
    }
}
