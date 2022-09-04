package com.api.lhs.surveillance.api;

import com.api.lhs.surveillance.domain.service.SurveillanceService;
import com.api.lhs.surveillance.mapping.SurveillanceMapper;
import com.api.lhs.surveillance.resource.CreateSurveillanceResource;
import com.api.lhs.surveillance.resource.SurveillanceResource;
import com.api.lhs.surveillance.resource.UpdateSurveillanceResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Surveillance")
@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class SurveillanceController {
    @Autowired
    private SurveillanceService surveillanceService;

    @Autowired
    private SurveillanceMapper surveillanceMapper;

    @Operation(summary = "Get All Surveillances", description = "Get All Surveillances")
    @GetMapping("surveillances")
    public List<SurveillanceResource> getAll(){
        return surveillanceMapper.toResource(surveillanceService.getAll());
    }

    @Operation(summary = "Get Surveillance by Id", description = "Get Surveillance by Id")
    @GetMapping("surveillances/{surveillanceId}")
    public SurveillanceResource getSurveillanceById(@PathVariable Long surveillanceId){
        return surveillanceMapper.toResource(surveillanceService.getById(surveillanceId));
    }

    @Operation(summary = "Get Surveillances by PatientId", description = "Get All Surveillances by PatientId")
    @GetMapping("patients/{patientId}/surveillances")
    public List<SurveillanceResource> getSurveillancesByPatientId(@PathVariable Long patientId){
        return surveillanceMapper.toResource(surveillanceService.getByPatientId(patientId));
    }

    @Operation(summary = "Get Surveillances by DoctorId", description = "Get All Surveillances by DoctorId")
    @GetMapping("doctors/{doctorId}/surveillances")
    public List<SurveillanceResource> getSurveillancesByDoctorId(@PathVariable Long doctorId){
        return surveillanceMapper.toResource(surveillanceService.getByDoctorId(doctorId));
    }

    @Operation(summary = "Get Surveillances by PatientId and DoctorId", description = "Get All Surveillances by PatientId and DoctorId")
    @GetMapping("patients/{patientId}/doctors/{doctorId}/surveillances")
    public List<SurveillanceResource> getSurveillancesByPatientIdAndDoctorId(@PathVariable Long patientId, @PathVariable Long doctorId){
        return surveillanceMapper.toResource(surveillanceService.getByPatientIdAndDoctorId(patientId, doctorId));
    }

    @Operation(summary = "Create Surveillance", description = "Create Surveillance")
    @PostMapping("patients/{patientId}/doctors/{doctorId}/surveillances")
    public SurveillanceResource createSurveillance(@RequestBody CreateSurveillanceResource surveillanceResource, @PathVariable Long patientId, @PathVariable Long doctorId){
        return surveillanceMapper.toResource(surveillanceService.create(surveillanceMapper.toModel(surveillanceResource), patientId, doctorId));
    }

    @Operation(summary = "Update Surveillance", description = "Update Surveillance")
    @PutMapping("surveillances/{surveillanceId}")
    public SurveillanceResource updateSurveillance(@PathVariable Long surveillanceId, @RequestBody UpdateSurveillanceResource surveillanceResource){
        return surveillanceMapper.toResource(surveillanceService.update(surveillanceId, surveillanceMapper.toModel(surveillanceResource)));
    }

    @Operation(summary = "Delete Surveillance", description = "Delete Surveillance")
    @DeleteMapping("surveillances/{surveillanceId}")
    public void deleteSurveillance(@PathVariable Long surveillanceId){
        surveillanceService.delete(surveillanceId);
    }
}
