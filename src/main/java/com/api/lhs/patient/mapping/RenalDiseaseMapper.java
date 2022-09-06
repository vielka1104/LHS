package com.api.lhs.patient.mapping;

import com.api.lhs.patient.domain.entity.RenalDisease;
import com.api.lhs.patient.resource.CreateRenalDiseaseResource;
import com.api.lhs.patient.resource.RenalDiseaseResource;
import com.api.lhs.patient.resource.UpdateRenalDiseaseResource;
import com.api.lhs.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RenalDiseaseMapper {
    @Autowired
    private EnhancedModelMapper mapper;
    public RenalDiseaseResource toResource(RenalDisease model) { return mapper.map(model, RenalDiseaseResource.class); }
    public List<RenalDiseaseResource> toResource(List<RenalDisease> model) { return mapper.mapList(model, RenalDiseaseResource.class); }
    public RenalDisease toModel(CreateRenalDiseaseResource resource) { return mapper.map(resource, RenalDisease.class); }
    public RenalDisease toModel(UpdateRenalDiseaseResource resource) { return mapper.map(resource, RenalDisease.class); }
}
