package com.api.lhs.ehr.mapping;

import com.api.lhs.ehr.domain.entity.Diagnosis;
import com.api.lhs.ehr.resource.CreateDiagnosisResource;
import com.api.lhs.ehr.resource.DiagnosisResource;
import com.api.lhs.ehr.resource.UpdateDiagnosisResource;
import com.api.lhs.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DiagnosisMapper {
    @Autowired
    private EnhancedModelMapper mapper;
    public DiagnosisResource toResource(Diagnosis model) { return mapper.map(model, DiagnosisResource.class); }
    public List<DiagnosisResource> toResource(List<Diagnosis> model) { return mapper.mapList(model, DiagnosisResource.class); }
    public Diagnosis toModel(CreateDiagnosisResource resource) { return mapper.map(resource, Diagnosis.class); }
    public Diagnosis toModel(UpdateDiagnosisResource resource) { return mapper.map(resource, Diagnosis.class); }
}
