package com.api.lhs.ehr.api;

import com.api.lhs.ehr.domain.service.PatientMedicineService;
import com.api.lhs.ehr.mapping.PatientMedicineMapper;
import com.api.lhs.ehr.resource.CreatePatientMedicineResource;
import com.api.lhs.ehr.resource.PatientMedicineResource;
import com.api.lhs.ehr.resource.UpdatePatientMedicineResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Patient Medicine")
@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class PatientMedicineController {
    @Autowired
    private PatientMedicineService patientMedicineService;
    @Autowired
    private PatientMedicineMapper patientMedicineMapper;

    @Operation(summary = "Get All Patient Medicine", description = "Get All Patient Medicine")
    @GetMapping("patient-medicine")
    public List<PatientMedicineResource> getAllPatientMedicine(){
        return patientMedicineMapper.toResource(patientMedicineService.getAll());
    }

    @Operation(summary = "Get Patient Medicine by Id", description = "Get Patient Medicine by Id")
    @GetMapping("patient-medicine/{patientMedicineId}")
    public PatientMedicineResource getPatientMedicineById(@PathVariable Long patientMedicineId){
        return patientMedicineMapper.toResource(patientMedicineService.getById(patientMedicineId));
    }

    @Operation(summary = "Get Patient Medicine by Patient Id", description = "Get Patient Medicine by Patient Id")
    @GetMapping("patient-medicine/patient/{patientId}")
    public List<PatientMedicineResource> getPatientMedicineByPatientId(@PathVariable Long patientId){
        return patientMedicineMapper.toResource(patientMedicineService.getByPatientId(patientId));
    }

    @Operation(summary = "Get Patient Medicine by Medicine Id", description = "Get Patient Medicine by Medicine Id")
    @GetMapping("patient-medicine/medicine/{medicineId}")
    public List<PatientMedicineResource> getPatientMedicineByMedicineId(@PathVariable Long medicineId){
        return patientMedicineMapper.toResource(patientMedicineService.getByMedicineId(medicineId));
    }

    @Operation(summary = "Create New Patient Medicine", description = "Create New Patient Medicine")
    @PostMapping("patients/{patientId}/medicine/{medicineId}/patient-medicine")
    public PatientMedicineResource createPatientMedicine(@PathVariable Long patientId, @PathVariable Long medicineId, @RequestBody CreatePatientMedicineResource model){
        return patientMedicineMapper.toResource(patientMedicineService.create(patientMedicineMapper.toModel(model), patientId, medicineId));
    }

    @Operation(summary = "Update Patient Medicine", description = "Update Patient Medicine")
    @PutMapping("patient-medicine/{patientMedicineId}")
    public PatientMedicineResource updatePatientMedicine(@PathVariable Long patientMedicineId, @RequestBody UpdatePatientMedicineResource model){
        return patientMedicineMapper.toResource(patientMedicineService.update(patientMedicineId, patientMedicineMapper.toModel(model)));
    }

    @Operation(summary = "Delete Patient Medicine", description = "Delete Patient Medicine")
    @DeleteMapping("patient-medicine/{patientMedicineId}")
    public void deletePatientMedicine(@PathVariable Long patientMedicineId){
        patientMedicineService.delete(patientMedicineId);
    }
}
