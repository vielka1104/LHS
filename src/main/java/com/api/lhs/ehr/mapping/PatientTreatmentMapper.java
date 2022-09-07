package com.api.lhs.ehr.mapping;

import com.api.lhs.ehr.domain.entity.PatientTreatment;
import com.api.lhs.ehr.resource.CreatePatientTreatmentResource;
import com.api.lhs.ehr.resource.PatientTreatmentResource;
import com.api.lhs.ehr.resource.UpdatePatientTreatmentResource;
import com.api.lhs.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientTreatmentMapper {
    @Autowired
    private EnhancedModelMapper mapper;
    public PatientTreatmentResource toResource(PatientTreatment model) { return mapper.map(model, PatientTreatmentResource.class); }
    public List<PatientTreatmentResource> toResource(List<PatientTreatment> model) { return mapper.mapList(model, PatientTreatmentResource.class); }
    public PatientTreatment toModel(CreatePatientTreatmentResource resource) { return mapper.map(resource, PatientTreatment.class); }
    public PatientTreatment toModel(UpdatePatientTreatmentResource resource) { return mapper.map(resource, PatientTreatment.class); }
}
