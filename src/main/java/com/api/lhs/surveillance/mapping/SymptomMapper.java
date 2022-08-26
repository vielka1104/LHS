package com.api.lhs.surveillance.mapping;

import com.api.lhs.shared.mapping.EnhancedModelMapper;
import com.api.lhs.surveillance.domain.entity.Symptom;
import com.api.lhs.surveillance.resource.CreateSymptomResource;
import com.api.lhs.surveillance.resource.SymptomResource;
import com.api.lhs.surveillance.resource.UpdateSymptomResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class SymptomMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public SymptomResource toResource(Symptom model) { return mapper.map(model, SymptomResource.class); }
    public List<SymptomResource> toResource(List<Symptom> model) { return  mapper.mapList(model, SymptomResource.class); }
    public Symptom toModel(CreateSymptomResource resource) { return mapper.map(resource, Symptom.class); }
    public Symptom toModel(UpdateSymptomResource resource) { return mapper.map(resource, Symptom.class); }
}
