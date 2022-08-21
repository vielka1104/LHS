package com.api.lhs.doctor.mapping;

import com.api.lhs.doctor.domain.entity.Doctor;
import com.api.lhs.doctor.resource.CreateDoctorResource;
import com.api.lhs.doctor.resource.DoctorResource;
import com.api.lhs.doctor.resource.UpdateDoctorResource;
import com.api.lhs.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class DoctorMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public DoctorResource toResource(Doctor model){
        return mapper.map(model, DoctorResource.class);
    }

    public List<DoctorResource> toResource(List<Doctor>model){
        return mapper.mapList(model, DoctorResource.class);
    }

    public Doctor toModel(CreateDoctorResource resource){
        return mapper.map(resource, Doctor.class);
    }

    public Doctor toModel(UpdateDoctorResource resource){
        return mapper.map(resource, Doctor.class);
    }
}
