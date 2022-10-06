package com.api.lhs.medicalCare.api;

import com.api.lhs.medicalCare.domain.service.MedicalCareService;
import com.api.lhs.medicalCare.mapping.MedicalCareMapper;
import com.api.lhs.medicalCare.resource.CreateMedicalCareResource;
import com.api.lhs.medicalCare.resource.MedicalCareResource;
import com.api.lhs.medicalCare.resource.UpdateMedicalCareResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "MedicalCare")
@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class MedicalCareController {
    @Autowired
    private MedicalCareService medicalCareService;

    @Autowired
    private MedicalCareMapper medicalCareMapper;

    @Operation(summary = "Get All Medical Cares", description = "Get All Medical Cares")
    @GetMapping("medical-care")
    public List<MedicalCareResource> getAll(){
        return medicalCareMapper.toResource(medicalCareService.getAll());
    }

    @Operation(summary = "Get MedicalCare by Id", description = "Get MedicalCare by Id")
    @GetMapping("medical-care/{medicalCareId}")
    public MedicalCareResource getMedicalCareById(@PathVariable Long medicalCareId){
        return medicalCareMapper.toResource(medicalCareService.getById(medicalCareId));
    }

    @Operation(summary = "Get Medical Cares by PatientId", description = "Get All Medical Cares by PatientId")
    @GetMapping("patients/{patientId}/medical-care")
    public List<MedicalCareResource> getMedicalCaresByPatientId(@PathVariable Long patientId){
        return medicalCareMapper.toResource(medicalCareService.getByPatientId(patientId));
    }

    @Operation(summary = "Create MedicalCare", description = "Create MedicalCare")
    @PostMapping("patients/{patientId}/medical-care")
    public MedicalCareResource createMedicalCare(@RequestBody CreateMedicalCareResource medicalCareResource, @PathVariable Long patientId){
        return medicalCareMapper.toResource(medicalCareService.create(medicalCareMapper.toModel(medicalCareResource), patientId));
    }

    @Operation(summary = "Update MedicalCare", description = "Update MedicalCare")
    @PutMapping("medical-care/{medicalCareId}")
    public MedicalCareResource updateMedicalCare(@PathVariable Long medicalCareId, @RequestBody UpdateMedicalCareResource medicalCareResource){
        return medicalCareMapper.toResource(medicalCareService.update(medicalCareId, medicalCareMapper.toModel(medicalCareResource)));
    }

    @Operation(summary = "Delete MedicalCare", description = "Delete MedicalCare")
    @DeleteMapping("medical-care/{medicalCareId}")
    public void deleteMedicalCare(@PathVariable Long medicalCareId){
        medicalCareService.delete(medicalCareId);
    }
}
