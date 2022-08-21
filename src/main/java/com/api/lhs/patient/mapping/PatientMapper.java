package com.api.lhs.patient.mapping;

import com.api.lhs.patient.domain.entity.Patient;
import com.api.lhs.patient.resource.CreatePatientResource;
import com.api.lhs.patient.resource.PatientResource;
import com.api.lhs.patient.resource.UpdatePatientResource;
import com.api.lhs.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class PatientMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public PatientResource toResource(Patient model) { return mapper.map(model, PatientResource.class); }
    public List<PatientResource> toResource(List<Patient> model) { return  mapper.mapList(model, PatientResource.class); }
    public Patient toModel(CreatePatientResource resource) { return mapper.map(resource, Patient.class); }
    public Patient toModel(UpdatePatientResource resource) { return mapper.map(resource, Patient.class); }
}
