package com.api.lhs.admin.mapping;

import com.api.lhs.admin.domain.entity.Admin;
import com.api.lhs.admin.resource.AdminResource;
import com.api.lhs.admin.resource.CreateAdminResource;
import com.api.lhs.admin.resource.UpdateAdminResource;
import com.api.lhs.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class AdminMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public AdminResource toResource(Admin model) { return mapper.map(model, AdminResource.class); }
    public List<AdminResource> toResource(List<Admin> model) { return  mapper.mapList(model, AdminResource.class); }
    public Admin toModel(CreateAdminResource resource) { return mapper.map(resource, Admin.class); }
    public Admin toModel(UpdateAdminResource resource) { return mapper.map(resource, Admin.class); }
}
