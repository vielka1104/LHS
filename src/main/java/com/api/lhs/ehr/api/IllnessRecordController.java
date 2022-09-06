package com.api.lhs.ehr.api;

import com.api.lhs.ehr.domain.service.IllnessRecordService;
import com.api.lhs.ehr.mapping.IllnessRecordMapper;
import com.api.lhs.ehr.resource.CreateIllnessRecordResource;
import com.api.lhs.ehr.resource.IllnessRecordResource;
import com.api.lhs.ehr.resource.UpdateIllnessRecordResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "IllnessRecord")
@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class IllnessRecordController {
    @Autowired
    private IllnessRecordService illnessRecordService;
    @Autowired
    private IllnessRecordMapper illnessRecordMapper;

    @Operation(summary = "Get All IllnessRecords", description = "Get All IllnessRecords")
    @GetMapping("illnessRecords")
    public List<IllnessRecordResource> getAll(){
        return illnessRecordMapper.toResource(illnessRecordService.getAll());
    }

    @Operation(summary = "Get IllnessRecord by Id", description = "Get IllnessRecord by Id")
    @GetMapping("illnessRecords/{illnessRecordId}")
    public IllnessRecordResource getIllnessRecordById(@PathVariable Long illnessRecordId){
        return illnessRecordMapper.toResource(illnessRecordService.getById(illnessRecordId));
    }

    @Operation(summary = "Get IllnessRecords by PatientId", description = "Get All IllnessRecords by PatientId")
    @GetMapping("patients/{patientId}/illnessRecords")
    public List<IllnessRecordResource> getIllnessRecordsByPatientId(@PathVariable Long patientId){
        return illnessRecordMapper.toResource(illnessRecordService.getIllnessRecordsByPatientId(patientId));
    }

    @Operation(summary = "Get IllnessRecords by PatientId and Illness Name", description = "Get All IllnessRecords by PatientId and Illness Name")
    @GetMapping("patients/{patientId}/illness/{illness}/illnessRecords")
    public List<IllnessRecordResource> getIllnessRecordsByPatientIdAndIllnessName(@PathVariable Long patientId, @PathVariable String illness){
        return illnessRecordMapper.toResource(illnessRecordService.getIllnessRecordsByPatientIdAndName(patientId, illness));
    }

    @Operation(summary = "Create IllnessRecord", description = "Create IllnessRecord")
    @PostMapping("patients/{patientId}/illnessRecords")
    public IllnessRecordResource createIllnessRecord(@RequestBody CreateIllnessRecordResource model, @PathVariable Long patientId){
        return illnessRecordMapper.toResource(illnessRecordService.create(illnessRecordMapper.toModel(model), patientId));
    }

    @Operation(summary = "Update IllnessRecord", description = "Update IllnessRecord")
    @PutMapping("illnessRecords/{illnessRecordId}")
    public IllnessRecordResource updateIllnessRecord(@RequestBody UpdateIllnessRecordResource model, @PathVariable Long illnessRecordId){
        return illnessRecordMapper.toResource(illnessRecordService.update(illnessRecordId, illnessRecordMapper.toModel(model)));
    }

    @Operation(summary = "Delete IllnessRecord", description = "Delete IllnessRecord")
    @DeleteMapping("illnessRecords/{illnessRecordId}")
    public void deleteIllnessRecord(@PathVariable Long illnessRecordId){
        illnessRecordService.delete(illnessRecordId);
    }
}
