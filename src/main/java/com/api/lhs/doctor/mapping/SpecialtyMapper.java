package com.api.lhs.doctor.mapping;

import com.api.lhs.shared.mapping.EnhancedModelMapper;
import com.api.lhs.doctor.domain.entity.Specialty;
import com.api.lhs.doctor.resource.CreateSpecialtyResource;
import com.api.lhs.doctor.resource.SpecialtyResource;
import com.api.lhs.doctor.resource.UpdateSpecialtyResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class SpecialtyMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public SpecialtyResource toResource(Specialty model) { return mapper.map(model, SpecialtyResource.class); }
    public List<SpecialtyResource> toResource(List<Specialty> model) { return mapper.mapList(model, SpecialtyResource.class); }
    public Specialty toModel(CreateSpecialtyResource resource) { return mapper.map(resource, Specialty.class); }
    public Specialty toModel(UpdateSpecialtyResource resource) { return mapper.map(resource, Specialty.class); }
}
