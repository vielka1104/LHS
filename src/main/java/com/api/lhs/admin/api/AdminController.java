package com.api.lhs.admin.api;

import com.api.lhs.admin.domain.service.AdminService;
import com.api.lhs.admin.mapping.AdminMapper;
import com.api.lhs.admin.resource.AdminResource;
import com.api.lhs.admin.resource.CreateAdminResource;
import com.api.lhs.admin.resource.UpdateAdminResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Admin")
@RestController
@RequestMapping("api/v1/admins")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminMapper adminMapper;

    @Operation(summary = "Get All Admins", description = "Get All Admins")
    @GetMapping
    public List<AdminResource> getAllAdmins(){
        return adminMapper.toResource(adminService.getAll());
    }

    @Operation(summary = "Get Admin by Id", description = "Get Admin by Id")
    @GetMapping("{adminId}")
    public AdminResource getAdminById(@PathVariable Long adminId){
        return adminMapper.toResource(adminService.getById(adminId));
    }

    @Operation(summary = "Get Admin by Username", description = "Get Admin by Username")
    @GetMapping("username/{username}")
    public AdminResource getAdminByUserName(@PathVariable String username){
        return adminMapper.toResource(adminService.getByUserName(username));
    }

    @Operation(summary = "Create New Admin", description = "Create New Admin")
    @PostMapping
    public AdminResource createAdmin(@RequestBody CreateAdminResource model){
        return adminMapper.toResource(adminService.create(adminMapper.toModel(model)));
    }

    @Operation(summary = "Update Admin", description = "Update Admin")
    @PutMapping("{adminId}")
    public AdminResource updateAdmin(@PathVariable Long adminId, @RequestBody UpdateAdminResource model){
        return adminMapper.toResource(adminService.update(adminId, adminMapper.toModel(model)));
    }

    @Operation(summary = "Delete Admin", description = "Delete Admin")
    @DeleteMapping("{adminId}")
    public void deleteAdmin(@PathVariable Long adminId){
        adminService.delete(adminId);
    }
}
