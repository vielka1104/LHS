package com.api.lhs.staff.api;

import com.api.lhs.staff.domain.service.StaffService;
import com.api.lhs.staff.mapping.StaffMapper;
import com.api.lhs.staff.resource.StaffResource;
import com.api.lhs.staff.resource.CreateStaffResource;
import com.api.lhs.staff.resource.UpdateStaffResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Staff")
@RestController
@RequestMapping("api/v1/admins")
@CrossOrigin
public class StaffController {
    @Autowired
    private StaffService staffService;

    @Autowired
    private StaffMapper staffMapper;

    @Operation(summary = "Get All Staff members", description = "Get All Staff members")
    @GetMapping
    public List<StaffResource> getAllStaffs(){
        return staffMapper.toResource(staffService.getAll());
    }

    @Operation(summary = "Get Staff by Id", description = "Get Staff by Id")
    @GetMapping("{staffId}")
    public StaffResource getStaffById(@PathVariable Long staffId){
        return staffMapper.toResource(staffService.getById(staffId));
    }

    @Operation(summary = "Get Staff by Username", description = "Get Staff by Username")
    @GetMapping("username/{username}")
    public StaffResource getStaffByUserName(@PathVariable String username){
        return staffMapper.toResource(staffService.getByUserName(username));
    }

    @Operation(summary = "Create New Staff", description = "Create New Staff")
    @PostMapping
    public StaffResource createStaff(@RequestBody CreateStaffResource model){
        return staffMapper.toResource(staffService.create(staffMapper.toModel(model)));
    }

    @Operation(summary = "Update Staff", description = "Update Staff")
    @PutMapping("{staffId}")
    public StaffResource updateStaff(@PathVariable Long staffId, @RequestBody UpdateStaffResource model){
        return staffMapper.toResource(staffService.update(staffId, staffMapper.toModel(model)));
    }

    @Operation(summary = "Delete Staff", description = "Delete Staff")
    @DeleteMapping("{staffId}")
    public void deleteStaff(@PathVariable Long staffId){
        staffService.delete(staffId);
    }
}
