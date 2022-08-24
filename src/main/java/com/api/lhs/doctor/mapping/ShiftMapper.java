package com.api.lhs.doctor.mapping;

import com.api.lhs.doctor.domain.entity.Shift;
import com.api.lhs.doctor.resource.CreateShiftResource;
import com.api.lhs.doctor.resource.ShiftResource;
import com.api.lhs.doctor.resource.UpdateShiftResource;
import com.api.lhs.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ShiftMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public ShiftResource toResource(Shift model){
        return mapper.map(model, ShiftResource.class);
    }

    public List<ShiftResource> toResource(List<Shift> model){
        return mapper.mapList(model, ShiftResource.class);
    }

    public Shift toModel(CreateShiftResource resource){
        return mapper.map(resource, Shift.class);
    }

    public Shift toModel(UpdateShiftResource resource){
        return mapper.map(resource, Shift.class);
    }
}
