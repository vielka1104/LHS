package com.api.lhs.surveillance.api;

import com.api.lhs.surveillance.domain.service.SymptomService;
import com.api.lhs.surveillance.mapping.SymptomMapper;
import com.api.lhs.surveillance.resource.CreateSymptomResource;
import com.api.lhs.surveillance.resource.SymptomResource;
import com.api.lhs.surveillance.resource.UpdateSymptomResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Symptom")
@RestController
@RequestMapping("api/v1/symptom")
@CrossOrigin
public class SymptomController {
    @Autowired
    private SymptomService symptomService;

    @Autowired
    private SymptomMapper symptomMapper;

    @Operation(summary = "Get All Symptom", description = "Get All Symptom")
    @GetMapping
    public List<SymptomResource> getAllSymptom(){
        return symptomMapper.toResource(symptomService.getAll());
    }

    @Operation(summary = "Get Symptom by Id", description = "Get Symptom by Id")
    @GetMapping("{symptomId}")
    public SymptomResource getSymptomById(@PathVariable Long symptomId){
        return symptomMapper.toResource(symptomService.getById(symptomId));
    }

    @Operation(summary = "Create New Symptom", description = "Create New Symptom")
    @PostMapping
    public SymptomResource createSymptom(@RequestBody CreateSymptomResource model){
        return symptomMapper.toResource(symptomService.create(symptomMapper.toModel(model)));
    }

    @Operation(summary = "Update Symptom", description = "Update Symptom")
    @PutMapping("{symptomId}")
    public SymptomResource updateSymptom(@PathVariable Long symptomId, @RequestBody UpdateSymptomResource model){
        return symptomMapper.toResource(symptomService.update(symptomId, symptomMapper.toModel(model)));
    }

    @Operation(summary = "Delete Symptom", description = "Delete Symptom")
    @DeleteMapping("{symptomId}")
    public void deleteSymptom(@PathVariable Long symptomId){
        symptomService.delete(symptomId);
    }
}
