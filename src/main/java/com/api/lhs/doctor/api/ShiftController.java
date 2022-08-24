package com.api.lhs.doctor.api;

import com.api.lhs.doctor.domain.service.ShiftService;
import com.api.lhs.doctor.mapping.ShiftMapper;
import com.api.lhs.doctor.resource.CreateShiftResource;
import com.api.lhs.doctor.resource.ShiftResource;
import com.api.lhs.doctor.resource.UpdateShiftResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Shift")
@RestController
@RequestMapping("api/v1/shifts")
@CrossOrigin
public class ShiftController {
    @Autowired
    private ShiftService shiftService;

    @Autowired
    private ShiftMapper shiftMapper;

    @Operation(summary = "Get All Shifts", description = "Get All Shifts")
    @GetMapping
    public List<ShiftResource> getAllShifts(){
        return shiftMapper.toResource(shiftService.getAll());
    }

    @Operation(summary = "Get Shift by Id", description = "Get Shift by Id")
    @GetMapping("{shiftId}")
    public ShiftResource getShiftById(@PathVariable Long shiftId){
        return shiftMapper.toResource(shiftService.getById(shiftId));
    }

    @Operation(summary = "Get Shift by Name", description = "Get Shift by Name")
    @GetMapping("name/{name}")
    public List<ShiftResource> getShiftByUserName(@PathVariable String name){
        return shiftMapper.toResource(shiftService.getByName(name));
    }

    @Operation(summary = "Create New Shift", description = "Create New Shift")
    @PostMapping
    public ShiftResource createShift(@RequestBody CreateShiftResource model){
        return shiftMapper.toResource(shiftService.create(shiftMapper.toModel(model)));
    }

    @Operation(summary = "Update Shift", description = "Update Shift")
    @PutMapping("{shiftId}")
    public ShiftResource updateShift(@PathVariable Long shiftId, @RequestBody UpdateShiftResource model){
        return shiftMapper.toResource(shiftService.update(shiftId, shiftMapper.toModel(model)));
    }

    @Operation(summary = "Delete Shift", description = "Delete Shift")
    @DeleteMapping("{shiftId}")
    public void deleteShift(@PathVariable Long shiftId){
        shiftService.delete(shiftId);
    }
}
