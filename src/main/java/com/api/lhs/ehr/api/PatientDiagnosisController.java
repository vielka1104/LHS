package com.api.lhs.ehr.api;

import com.api.lhs.ehr.domain.service.PatientDiagnosisService;
import com.api.lhs.ehr.mapping.PatientDiagnosisMapper;
import com.api.lhs.ehr.resource.CreatePatientDiagnosisResource;
import com.api.lhs.ehr.resource.PatientDiagnosisResource;
import com.api.lhs.ehr.resource.UpdatePatientDiagnosisResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Patient Diagnosis")
@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class PatientDiagnosisController {
    @Autowired
    private PatientDiagnosisService patientDiagnosisService;
    @Autowired
    private PatientDiagnosisMapper patientDiagnosisMapper;

    @Operation(summary = "Get All Patient Diagnosis", description = "Get All Patient Diagnosis")
    @GetMapping("patientDiagnosis")
    public List<PatientDiagnosisResource> getAllPatientDiagnosis(){
        return patientDiagnosisMapper.toResource(patientDiagnosisService.getAll());
    }

    @Operation(summary = "Get Patient Diagnosis by Id", description = "Get Patient Diagnosis by Id")
    @GetMapping("patient-diagnosis/{patientDiagnosisId}")
    public PatientDiagnosisResource getPatientDiagnosisById(@PathVariable Long patientDiagnosisId){
        return patientDiagnosisMapper.toResource(patientDiagnosisService.getById(patientDiagnosisId));
    }

    @Operation(summary = "Get Patient Diagnosis by Patient Id", description = "Get Patient Diagnosis by Patient Id")
    @GetMapping("patient-diagnosis/patient/{patientId}")
    public List<PatientDiagnosisResource> getPatientDiagnosisByPatientId(@PathVariable Long patientId){
        return patientDiagnosisMapper.toResource(patientDiagnosisService.getByPatientId(patientId));
    }

    @Operation(summary = "Get Patient Diagnosis by Diagnosis Id", description = "Get Patient Diagnosis by Diagnosis Id")
    @GetMapping("patient-diagnosis/diagnosis/{diagnosisId}")
    public List<PatientDiagnosisResource> getPatientDiagnosisByDiagnosisId(@PathVariable Long diagnosisId){
        return patientDiagnosisMapper.toResource(patientDiagnosisService.getByDiagnosisId(diagnosisId));
    }

    @Operation(summary = "Create New Patient Diagnosis", description = "Create New Patient Diagnosis")
    @PostMapping("patients/{patientId}/diagnosis/{diagnosisId}/patient-diagnosis")
    public PatientDiagnosisResource createPatientDiagnosis(@PathVariable Long patientId, @PathVariable Long diagnosisId, @RequestBody CreatePatientDiagnosisResource model){
        return patientDiagnosisMapper.toResource(patientDiagnosisService.create(patientDiagnosisMapper.toModel(model), patientId, diagnosisId));
    }

    @Operation(summary = "Update Patient Diagnosis", description = "Update Patient Diagnosis")
    @PutMapping("patient-diagnosis/{patientDiagnosisId}")
    public PatientDiagnosisResource updatePatientDiagnosis(@PathVariable Long patientDiagnosisId, @RequestBody UpdatePatientDiagnosisResource model){
        return patientDiagnosisMapper.toResource(patientDiagnosisService.update(patientDiagnosisId, patientDiagnosisMapper.toModel(model)));
    }

    @Operation(summary = "Delete Patient Diagnosis", description = "Delete Patient Diagnosis")
    @DeleteMapping("patient-diagnosis/{patientDiagnosisId}")
    public void deletePatientDiagnosis(@PathVariable Long patientDiagnosisId){
        patientDiagnosisService.delete(patientDiagnosisId);
    }
}
