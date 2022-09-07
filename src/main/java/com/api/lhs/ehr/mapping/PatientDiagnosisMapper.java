package com.api.lhs.ehr.mapping;

import com.api.lhs.ehr.domain.entity.PatientDiagnosis;
import com.api.lhs.ehr.resource.CreatePatientDiagnosisResource;
import com.api.lhs.ehr.resource.PatientDiagnosisResource;
import com.api.lhs.ehr.resource.UpdatePatientDiagnosisResource;
import com.api.lhs.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientDiagnosisMapper {
    @Autowired
    private EnhancedModelMapper mapper;
    public PatientDiagnosisResource toResource(PatientDiagnosis model) { return mapper.map(model, PatientDiagnosisResource.class); }
    public List<PatientDiagnosisResource> toResource(List<PatientDiagnosis> model) { return mapper.mapList(model, PatientDiagnosisResource.class); }
    public PatientDiagnosis toModel(CreatePatientDiagnosisResource resource) { return mapper.map(resource, PatientDiagnosis.class); }
    public PatientDiagnosis toModel(UpdatePatientDiagnosisResource resource) { return mapper.map(resource, PatientDiagnosis.class); }
}
