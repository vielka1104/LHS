package com.api.lhs.ehr.api;

import com.api.lhs.ehr.domain.service.TreatmentService;
import com.api.lhs.ehr.mapping.TreatmentMapper;
import com.api.lhs.ehr.resource.CreateTreatmentResource;
import com.api.lhs.ehr.resource.TreatmentResource;
import com.api.lhs.ehr.resource.UpdateTreatmentResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Treatment")
@RestController
@RequestMapping("api/v1/treatments")
@CrossOrigin
public class TreatmentController {
    @Autowired
    private TreatmentService treatmentService;
    @Autowired
    private TreatmentMapper treatmentMapper;

    @Operation(summary = "Get All Treatments", description = "Get All Treatments")
    @GetMapping
    public List<TreatmentResource> getAllTreatments(){
        return treatmentMapper.toResource(treatmentService.getAll());
    }

    @Operation(summary = "Get Treatment by Id", description = "Get Treatment by Id")
    @GetMapping("{treatmentId}")
    public TreatmentResource getTreatmentById(@PathVariable Long treatmentId){
        return treatmentMapper.toResource(treatmentService.getById(treatmentId));
    }

    @Operation(summary = "Get Treatment by Name", description = "Get Treatment by Name")
    @GetMapping("name/{name}")
    public List<TreatmentResource> getTreatmentByUserName(@PathVariable String name){
        return treatmentMapper.toResource(treatmentService.getTreatmentsByName(name));
    }

    @Operation(summary = "Create New Treatment", description = "Create New Treatment")
    @PostMapping
    public TreatmentResource createTreatment(@RequestBody CreateTreatmentResource model){
        return treatmentMapper.toResource(treatmentService.create(treatmentMapper.toModel(model)));
    }

    @Operation(summary = "Update Treatment", description = "Update Treatment")
    @PutMapping("{treatmentId}")
    public TreatmentResource updateTreatment(@PathVariable Long treatmentId, @RequestBody UpdateTreatmentResource model){
        return treatmentMapper.toResource(treatmentService.update(treatmentId, treatmentMapper.toModel(model)));
    }

    @Operation(summary = "Delete Treatment", description = "Delete Treatment")
    @DeleteMapping("{treatmentId}")
    public void deleteTreatment(@PathVariable Long treatmentId){
        treatmentService.delete(treatmentId);
    }
}
