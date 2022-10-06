package com.api.lhs.ehr.api;

import com.api.lhs.ehr.domain.service.PatientTreatmentService;
import com.api.lhs.ehr.mapping.PatientTreatmentMapper;
import com.api.lhs.ehr.resource.CreatePatientTreatmentResource;
import com.api.lhs.ehr.resource.PatientTreatmentResource;
import com.api.lhs.ehr.resource.UpdatePatientTreatmentResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Patient Treatment")
@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class PatientTreatmentController {
    @Autowired
    private PatientTreatmentService patientTreatmentService;
    @Autowired
    private PatientTreatmentMapper patientTreatmentMapper;

    @Operation(summary = "Get All Patient Treatments", description = "Get All Patient Treatments")
    @GetMapping("patient-treatments")
    public List<PatientTreatmentResource> getAllPatientTreatments(){
        return patientTreatmentMapper.toResource(patientTreatmentService.getAll());
    }

    @Operation(summary = "Get Patient Treatment by Id", description = "Get Patient Treatment by Id")
    @GetMapping("patient-treatments/{patientTreatmentId}")
    public PatientTreatmentResource getPatientTreatmentById(@PathVariable Long patientTreatmentId){
        return patientTreatmentMapper.toResource(patientTreatmentService.getById(patientTreatmentId));
    }

    @Operation(summary = "Get Patient Treatment by Patient Id", description = "Get Patient Treatment by Patient Id")
    @GetMapping("patient-treatments/patient/{patientId}")
    public List<PatientTreatmentResource> getPatientTreatmentByPatientId(@PathVariable Long patientId){
        return patientTreatmentMapper.toResource(patientTreatmentService.getByPatientId(patientId));
    }

    @Operation(summary = "Get Patient Treatment by Treatment Id", description = "Get Patient Treatment by Treatment Id")
    @GetMapping("patient-treatments/treatment/{treatmentId}")
    public List<PatientTreatmentResource> getPatientTreatmentByTreatmentId(@PathVariable Long treatmentId){
        return patientTreatmentMapper.toResource(patientTreatmentService.getByTreatmentId(treatmentId));
    }

    @Operation(summary = "Create Patient Treatment", description = "Create Patient Treatment")
    @PostMapping("patients/{patientId}/treatments/{treatmentId}/patient-treatments")
    public PatientTreatmentResource createPatientTreatment(@PathVariable Long patientId, @PathVariable Long treatmentId, @RequestBody CreatePatientTreatmentResource model){
        return patientTreatmentMapper.toResource(patientTreatmentService.create(patientTreatmentMapper.toModel(model), patientId, treatmentId));
    }

    @Operation(summary = "Update Patient Treatment", description = "Update Patient Treatment")
    @PutMapping("patient-treatments/{patientTreatmentId}")
    public PatientTreatmentResource updatePatientTreatment(@PathVariable Long patientTreatmentId, @RequestBody UpdatePatientTreatmentResource model){
        return patientTreatmentMapper.toResource(patientTreatmentService.update(patientTreatmentId, patientTreatmentMapper.toModel(model)));
    }

    @Operation(summary = "Delete Patient Treatment", description = "Delete Patient Treatment")
    @DeleteMapping("patient-treatments/{patientTreatmentId}")
    public void deletePatientTreatment(@PathVariable Long patientTreatmentId){
        patientTreatmentService.delete(patientTreatmentId);
    }
}
