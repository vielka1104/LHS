package com.api.lhs.ehr.api;

import com.api.lhs.ehr.domain.service.DiagnosisService;
import com.api.lhs.ehr.mapping.DiagnosisMapper;
import com.api.lhs.ehr.resource.CreateDiagnosisResource;
import com.api.lhs.ehr.resource.DiagnosisResource;
import com.api.lhs.ehr.resource.UpdateDiagnosisResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Diagnosis")
@RestController
@RequestMapping("api/v1/diagnosis")
@CrossOrigin
public class DiagnosisController {
    @Autowired
    private DiagnosisService diagnosisService;
    @Autowired
    private DiagnosisMapper diagnosisMapper;

    @Operation(summary = "Get All Diagnosis", description = "Get All Diagnosis")
    @GetMapping
    public List<DiagnosisResource> getAllDiagnosis(){
        return diagnosisMapper.toResource(diagnosisService.getAll());
    }

    @Operation(summary = "Get Diagnosis by Id", description = "Get Diagnosis by Id")
    @GetMapping("{diagnosisId}")
    public DiagnosisResource getDiagnosisById(@PathVariable Long diagnosisId){
        return diagnosisMapper.toResource(diagnosisService.getById(diagnosisId));
    }

    @Operation(summary = "Get Diagnosis by Name", description = "Get Diagnosis by Name")
    @GetMapping("name/{name}")
    public List<DiagnosisResource> getDiagnosisByName(@PathVariable String name){
        return diagnosisMapper.toResource(diagnosisService.getDiagnosisByName(name));
    }

    @Operation(summary = "Create New Diagnosis", description = "Create New Diagnosis")
    @PostMapping
    public DiagnosisResource createDiagnosis(@RequestBody CreateDiagnosisResource model){
        return diagnosisMapper.toResource(diagnosisService.create(diagnosisMapper.toModel(model)));
    }

    @Operation(summary = "Update Diagnosis", description = "Update Diagnosis")
    @PutMapping("{diagnosisId}")
    public DiagnosisResource updateDiagnosis(@PathVariable Long diagnosisId, @RequestBody UpdateDiagnosisResource model){
        return diagnosisMapper.toResource(diagnosisService.update(diagnosisId, diagnosisMapper.toModel(model)));
    }

    @Operation(summary = "Delete Diagnosis", description = "Delete Diagnosis")
    @DeleteMapping("{diagnosisId}")
    public void deleteDiagnosis(@PathVariable Long diagnosisId){
        diagnosisService.delete(diagnosisId);
    }
}
