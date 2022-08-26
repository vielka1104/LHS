package com.api.lhs.surveillance.api;

import com.api.lhs.surveillance.domain.service.NutritionService;
import com.api.lhs.surveillance.mapping.NutritionMapper;
import com.api.lhs.surveillance.resource.CreateNutritionResource;
import com.api.lhs.surveillance.resource.NutritionResource;
import com.api.lhs.surveillance.resource.UpdateNutritionResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Nutrition")
@RestController
@RequestMapping("api/v1/nutrition")
@CrossOrigin
public class NutritionController {
    @Autowired
    private NutritionService nutritionService;

    @Autowired
    private NutritionMapper nutritionMapper;

    @Operation(summary = "Get All Nutrition Plans", description = "Get All Nutrition Plans")
    @GetMapping
    public List<NutritionResource> getAllNutrition(){
        return nutritionMapper.toResource(nutritionService.getAll());
    }

    @Operation(summary = "Get Nutrition Plan by Id", description = "Get Nutrition Plan by Id")
    @GetMapping("{nutritionId}")
    public NutritionResource getNutritionById(@PathVariable Long nutritionId){
        return nutritionMapper.toResource(nutritionService.getById(nutritionId));
    }

    @Operation(summary = "Create New Nutrition Plan", description = "Create New Nutrition Plan")
    @PostMapping
    public NutritionResource createNutrition(@RequestBody CreateNutritionResource model){
        return nutritionMapper.toResource(nutritionService.create(nutritionMapper.toModel(model)));
    }

    @Operation(summary = "Update Nutrition Plan", description = "Update Nutrition Plan")
    @PutMapping("{nutritionId}")
    public NutritionResource updateNutrition(@PathVariable Long nutritionId, @RequestBody UpdateNutritionResource model){
        return nutritionMapper.toResource(nutritionService.update(nutritionId, nutritionMapper.toModel(model)));
    }

    @Operation(summary = "Delete Nutrition Plan", description = "Delete Nutrition Plan")
    @DeleteMapping("{nutritionId}")
    public void deleteNutrition(@PathVariable Long nutritionId){
        nutritionService.delete(nutritionId);
    }
}
