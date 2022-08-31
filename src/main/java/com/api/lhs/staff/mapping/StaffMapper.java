package com.api.lhs.staff.mapping;

import com.api.lhs.staff.domain.entity.Staff;
import com.api.lhs.staff.resource.StaffResource;
import com.api.lhs.staff.resource.CreateStaffResource;
import com.api.lhs.staff.resource.UpdateStaffResource;
import com.api.lhs.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class StaffMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public StaffResource toResource(Staff model) { return mapper.map(model, StaffResource.class); }
    public List<StaffResource> toResource(List<Staff> model) { return  mapper.mapList(model, StaffResource.class); }
    public Staff toModel(CreateStaffResource resource) { return mapper.map(resource, Staff.class); }
    public Staff toModel(UpdateStaffResource resource) { return mapper.map(resource, Staff.class); }
}
