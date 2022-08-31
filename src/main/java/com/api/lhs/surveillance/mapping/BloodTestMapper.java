package com.api.lhs.surveillance.mapping;

import com.api.lhs.shared.mapping.EnhancedModelMapper;
import com.api.lhs.surveillance.domain.entity.BloodTest;
import com.api.lhs.surveillance.resource.BloodTestResource;
import com.api.lhs.surveillance.resource.CreateBloodTestResource;
import com.api.lhs.surveillance.resource.UpdateBloodTestResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BloodTestMapper {
    @Autowired
    private EnhancedModelMapper mapper;
    public BloodTestResource toResource(BloodTest model) { return mapper.map(model, BloodTestResource.class); }
    public List<BloodTestResource> toResource(List<BloodTest> model) { return  mapper.mapList(model, BloodTestResource.class); }
    public BloodTest toModel(CreateBloodTestResource resource) { return mapper.map(resource, BloodTest.class); }
    public BloodTest toModel(UpdateBloodTestResource resource) { return mapper.map(resource, BloodTest.class); }
}
