package com.api.lhs.surveillance.mapping;

import com.api.lhs.shared.mapping.EnhancedModelMapper;
import com.api.lhs.surveillance.domain.entity.Nutrition;
import com.api.lhs.surveillance.resource.CreateNutritionResource;
import com.api.lhs.surveillance.resource.NutritionResource;
import com.api.lhs.surveillance.resource.UpdateNutritionResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class NutritionMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public NutritionResource toResource(Nutrition model) { return mapper.map(model, NutritionResource.class); }
    public List<NutritionResource> toResource(List<Nutrition> model) { return  mapper.mapList(model, NutritionResource.class); }
    public Nutrition toModel(CreateNutritionResource resource) { return mapper.map(resource, Nutrition.class); }
    public Nutrition toModel(UpdateNutritionResource resource) { return mapper.map(resource, Nutrition.class); }
}
