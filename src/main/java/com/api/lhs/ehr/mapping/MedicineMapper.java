package com.api.lhs.ehr.mapping;

import com.api.lhs.ehr.domain.entity.Medicine;
import com.api.lhs.ehr.resource.CreateMedicineResource;
import com.api.lhs.ehr.resource.MedicineResource;
import com.api.lhs.ehr.resource.UpdateMedicineResource;
import com.api.lhs.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MedicineMapper {
    @Autowired
    private EnhancedModelMapper mapper;
    public MedicineResource toResource(Medicine model) { return mapper.map(model, MedicineResource.class); }
    public List<MedicineResource> toResource(List<Medicine> model) { return mapper.mapList(model, MedicineResource.class); }
    public Medicine toModel(CreateMedicineResource resource) { return mapper.map(resource, Medicine.class); }
    public Medicine toModel(UpdateMedicineResource resource) { return mapper.map(resource, Medicine.class); }
}
