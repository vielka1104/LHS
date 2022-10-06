package com.api.lhs.medicalCare.mapping;

import com.api.lhs.medicalCare.domain.entity.MedicalCare;
import com.api.lhs.medicalCare.resource.CreateMedicalCareResource;
import com.api.lhs.medicalCare.resource.MedicalCareResource;
import com.api.lhs.medicalCare.resource.UpdateMedicalCareResource;
import com.api.lhs.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class MedicalCareMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public MedicalCareResource toResource(MedicalCare model){
        return mapper.map(model, MedicalCareResource.class);
    }

    public List<MedicalCareResource> toResource(List<MedicalCare>model){
        return mapper.mapList(model, MedicalCareResource.class);
    }

    public MedicalCare toModel(CreateMedicalCareResource resource){
        return mapper.map(resource, MedicalCare.class);
    }

    public MedicalCare toModel(UpdateMedicalCareResource resource){
        return mapper.map(resource, MedicalCare.class);
    }
}
