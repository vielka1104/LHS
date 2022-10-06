package com.api.lhs.ehr.mapping;

import com.api.lhs.ehr.domain.entity.PatientMedicine;
import com.api.lhs.ehr.resource.CreatePatientMedicineResource;
import com.api.lhs.ehr.resource.PatientMedicineResource;
import com.api.lhs.ehr.resource.UpdatePatientMedicineResource;
import com.api.lhs.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientMedicineMapper {
    @Autowired
    private EnhancedModelMapper mapper;
    public PatientMedicineResource toResource(PatientMedicine model) { return mapper.map(model, PatientMedicineResource.class); }
    public List<PatientMedicineResource> toResource(List<PatientMedicine> model) { return mapper.mapList(model, PatientMedicineResource.class); }
    public PatientMedicine toModel(CreatePatientMedicineResource resource) { return mapper.map(resource, PatientMedicine.class); }
    public PatientMedicine toModel(UpdatePatientMedicineResource resource) { return mapper.map(resource, PatientMedicine.class); }
}
