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
@RequestMapping("api/v1")
@CrossOrigin
public class PatientController {
    @Autowired
    private PatientService patientService;
    
    @Autowired
    private PatientMapper patientMapper;

    @Operation(summary = "Get All Patients", description = "Get All Patients")
    @GetMapping("patients")
    public List<PatientResource> getAllPatients(){
        return patientMapper.toResource(patientService.getAll());
    }

    @Operation(summary = "Get Patient by Id", description = "Get Patient by Id")
    @GetMapping("patients/{patientId}")
    public PatientResource getPatientById(@PathVariable Long patientId){
        return patientMapper.toResource(patientService.getById(patientId));
    }

    @Operation(summary = "Get Patient by Username", description = "Get Patient by Username")
    @GetMapping("patients/username/{username}")
    public List<PatientResource> getPatientByUserName(@PathVariable String username){
        return patientMapper.toResource(patientService.getByUserName(username));
    }

    @Operation(summary = "Get Patient by Email", description = "Get Patient by Email")
    @GetMapping("patients/email/{email}")
    public PatientResource getPatientByEmail(@PathVariable String email){
        return patientMapper.toResource(patientService.getByEmail(email));
    }

    @Operation(summary = "Get Patient by Document Number", description = "Get Patient by Document Number")
    @GetMapping("patients/document-number/{documentNumber}")
    public PatientResource getPatientByDocumentNumber(@PathVariable String documentNumber){
        return patientMapper.toResource(patientService.getByDocumentNumber(documentNumber));
    }

    @Operation(summary = "Get Patients by Renal Disease", description = "Get Patients by Renal Disease")
    @GetMapping("patients/renal-disease/{renalDisease}")
    public List<PatientResource> getPatientsByRenalDisease(@PathVariable Long renalDisease){
        return patientMapper.toResource(patientService.getByRenalDiseaseId(renalDisease));
    }

    @Operation(summary = "Get Patient by Complete Name", description = "Get Patient by Complete Name")
    @GetMapping("patients/name/{name}/lastName/{lastName}")
    public List<PatientResource> getPatientByFirstNameAndLastName(@PathVariable String name, @PathVariable String lastName){
        return patientMapper.toResource(patientService.getByNameAndLastName(name, lastName));
    }

    @Operation(summary = "Create New Patient", description = "Create New Patient")
    @PostMapping("renal-diseases/{renalDiseaseId}/patients")
    public PatientResource createPatient(@RequestBody CreatePatientResource model, @PathVariable Long renalDiseaseId){
        return patientMapper.toResource(patientService.create(renalDiseaseId, patientMapper.toModel(model)));
    }

    @Operation(summary = "Update Patient", description = "Update Patient")
    @PutMapping("patients/{patientId}")
    public PatientResource updatePatient(@PathVariable Long patientId, @RequestBody UpdatePatientResource model){
        return patientMapper.toResource(patientService.update(patientId, patientMapper.toModel(model)));
    }

    @Operation(summary = "Delete Patient", description = "Delete Patient")
    @DeleteMapping("patients/{patientId}")
    public void deletePatient(@PathVariable Long patientId){
        patientService.delete(patientId);
    }
}
