package com.api.lhs.surveillance.mapping;

import com.api.lhs.shared.mapping.EnhancedModelMapper;
import com.api.lhs.surveillance.domain.entity.Surveillance;
import com.api.lhs.surveillance.resource.CreateSurveillanceResource;
import com.api.lhs.surveillance.resource.SurveillanceResource;
import com.api.lhs.surveillance.resource.UpdateSurveillanceResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class SurveillanceMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public SurveillanceResource toResource(Surveillance model){
        return mapper.map(model, SurveillanceResource.class);
    }

    public List<SurveillanceResource> toResource(List<Surveillance> model){
        return mapper.mapList(model, SurveillanceResource.class);
    }

    public Surveillance toModel(CreateSurveillanceResource resource){
        return mapper.map(resource, Surveillance.class);
    }

    public Surveillance toModel(UpdateSurveillanceResource resource){
        return mapper.map(resource, Surveillance.class);
    }
}
