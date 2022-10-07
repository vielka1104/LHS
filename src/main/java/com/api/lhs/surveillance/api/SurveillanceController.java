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

    @Operation(summary = "Create Surveillance", description = "Create Surveillance")
    @PostMapping("patients/{patientId}/surveillances")
    public SurveillanceResource createSurveillance(@RequestBody CreateSurveillanceResource surveillanceResource, @PathVariable Long patientId){
        return surveillanceMapper.toResource(surveillanceService.create(surveillanceMapper.toModel(surveillanceResource), patientId));
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
