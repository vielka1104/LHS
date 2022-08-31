package com.api.lhs.surveillance.api;

import com.api.lhs.surveillance.domain.service.BloodTestService;
import com.api.lhs.surveillance.mapping.BloodTestMapper;
import com.api.lhs.surveillance.resource.BloodTestResource;
import com.api.lhs.surveillance.resource.CreateBloodTestResource;
import com.api.lhs.surveillance.resource.UpdateBloodTestResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "BloodTest")
@RestController
@RequestMapping("api/v1/bloodTest")
@CrossOrigin
public class BloodTestController {
    @Autowired
    private BloodTestService bloodTestService;

    @Autowired
    private BloodTestMapper bloodTestMapper;

    @Operation(summary = "Get All BloodTests", description = "Get All BloodTests")
    @GetMapping
    public List<BloodTestResource> getAllBloodTest(){
        return bloodTestMapper.toResource(bloodTestService.getAll());
    }

    @Operation(summary = "Get BloodTest by Id", description = "Get BloodTest by Id")
    @GetMapping("{bloodTestId}")
    public BloodTestResource getBloodTestById(@PathVariable Long bloodTestId){
        return bloodTestMapper.toResource(bloodTestService.getById(bloodTestId));
    }

    @Operation(summary = "Create New BloodTest", description = "Create New BloodTest")
    @PostMapping
    public BloodTestResource createBloodTest(@RequestBody CreateBloodTestResource model){
        return bloodTestMapper.toResource(bloodTestService.create(bloodTestMapper.toModel(model)));
    }

    @Operation(summary = "Update BloodTest", description = "Update BloodTest")
    @PutMapping("{bloodTestId}")
    public BloodTestResource updateBloodTest(@PathVariable Long bloodTestId, @RequestBody UpdateBloodTestResource model){
        return bloodTestMapper.toResource(bloodTestService.update(bloodTestId, bloodTestMapper.toModel(model)));
    }

    @Operation(summary = "Delete BloodTest", description = "Delete BloodTest")
    @DeleteMapping("{bloodTestId}")
    public void deleteBloodTest(@PathVariable Long bloodTestId){
        bloodTestService.delete(bloodTestId);
    }
}
