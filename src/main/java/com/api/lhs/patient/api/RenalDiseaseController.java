package com.api.lhs.patient.api;

import com.api.lhs.patient.domain.service.RenalDiseaseService;
import com.api.lhs.patient.mapping.RenalDiseaseMapper;
import com.api.lhs.patient.resource.CreateRenalDiseaseResource;
import com.api.lhs.patient.resource.RenalDiseaseResource;
import com.api.lhs.patient.resource.UpdateRenalDiseaseResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "RenalDisease")
@RestController
@RequestMapping("api/v1/renal-diseases")
@CrossOrigin
public class RenalDiseaseController {
    @Autowired
    private RenalDiseaseService renalDiseaseService;

    @Autowired
    private RenalDiseaseMapper renalDiseaseMapper;

    @Operation(summary = "Get All Renal Diseases", description = "Get All Renal Diseases")
    @GetMapping
    public List<RenalDiseaseResource> getAllRenalDiseases(){
        return renalDiseaseMapper.toResource(renalDiseaseService.getAll());
    }

    @Operation(summary = "Get Renal Disease by Id", description = "Get Renal Disease by Id")
    @GetMapping("{renalDiseaseId}")
    public RenalDiseaseResource getRenalDiseaseById(@PathVariable Long renalDiseaseId){
        return renalDiseaseMapper.toResource(renalDiseaseService.getById(renalDiseaseId));
    }

    @Operation(summary ="Create Renal Disease", description = "Create Renal Disease")
    @PostMapping
    public RenalDiseaseResource createRenalDisease(@RequestBody CreateRenalDiseaseResource model){
        return renalDiseaseMapper.toResource(renalDiseaseService.create(renalDiseaseMapper.toModel(model)));
    }

    @Operation(summary = "Update Renal Disease", description = "Update Renal Disease")
    @PutMapping("{renalDiseaseId}")
    public RenalDiseaseResource updateRenalDisease(@PathVariable Long renalDiseaseId, @RequestBody UpdateRenalDiseaseResource model){
        return renalDiseaseMapper.toResource(renalDiseaseService.update(renalDiseaseId, renalDiseaseMapper.toModel(model)));
    }

    @Operation(summary = "Delete Renal Disease", description = "Delete Renal Disease")
    @DeleteMapping("{renalDiseaseId}")
    public void deleteRenalDisease(@PathVariable Long renalDiseaseId){
        renalDiseaseService.delete(renalDiseaseId);
    }
}
