package com.api.lhs.ehr.mapping;

import com.api.lhs.ehr.domain.entity.Treatment;
import com.api.lhs.ehr.resource.CreateTreatmentResource;
import com.api.lhs.ehr.resource.TreatmentResource;
import com.api.lhs.ehr.resource.UpdateTreatmentResource;
import com.api.lhs.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TreatmentMapper {
    @Autowired
    private EnhancedModelMapper mapper;
    public TreatmentResource toResource(Treatment model) { return mapper.map(model, TreatmentResource.class); }
    public List<TreatmentResource> toResource(List<Treatment> model) { return mapper.mapList(model, TreatmentResource.class); }
    public Treatment toModel(CreateTreatmentResource resource) { return mapper.map(resource, Treatment.class); }
    public Treatment toModel(UpdateTreatmentResource resource) { return mapper.map(resource, Treatment.class); }
}
