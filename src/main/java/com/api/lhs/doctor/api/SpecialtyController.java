package com.api.lhs.doctor.api;

import com.api.lhs.doctor.domain.service.SpecialtyService;
import com.api.lhs.doctor.mapping.SpecialtyMapper;
import com.api.lhs.doctor.resource.CreateSpecialtyResource;
import com.api.lhs.doctor.resource.SpecialtyResource;
import com.api.lhs.doctor.resource.UpdateSpecialtyResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Specialty")
@RestController
@RequestMapping("api/v1/specialties")
@CrossOrigin
public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;
    
    @Autowired
    private SpecialtyMapper specialtyMapper;

    @Operation(summary = "Get All Specialties", description = "Get All Specialties")
    @GetMapping
    public List<SpecialtyResource> getAllSpecialties(){
        return specialtyMapper.toResource(specialtyService.getAll());
    }

    @Operation(summary = "Get Specialty by Id", description = "Get Specialty by Id")
    @GetMapping("{specialtyId}")
    public SpecialtyResource getSpecialtyById(@PathVariable Long specialtyId){
        return specialtyMapper.toResource(specialtyService.getById(specialtyId));
    }

    @Operation(summary = "Get Specialty by Name", description = "Get Specialty by Name")
    @GetMapping("name/{name}")
    public List<SpecialtyResource> getSpecialtyByUserName(@PathVariable String name){
        return specialtyMapper.toResource(specialtyService.getByName(name));
    }

    @Operation(summary = "Create New Specialty", description = "Create New Specialty")
    @PostMapping
    public SpecialtyResource createSpecialty(@RequestBody CreateSpecialtyResource model){
        return specialtyMapper.toResource(specialtyService.create(specialtyMapper.toModel(model)));
    }

    @Operation(summary = "Update Specialty", description = "Update Specialty")
    @PutMapping("{specialtyId}")
    public SpecialtyResource updateSpecialty(@PathVariable Long specialtyId, @RequestBody UpdateSpecialtyResource model){
        return specialtyMapper.toResource(specialtyService.update(specialtyId, specialtyMapper.toModel(model)));
    }

    @Operation(summary = "Delete Specialty", description = "Delete Specialty")
    @DeleteMapping("{specialtyId}")
    public void deleteSpecialty(@PathVariable Long specialtyId){
        specialtyService.delete(specialtyId);
    }
}
