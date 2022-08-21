package com.api.lhs.appointment.mapping;

import com.api.lhs.appointment.domain.entity.Appointment;
import com.api.lhs.appointment.resource.AppointmentResource;
import com.api.lhs.appointment.resource.CreateAppointmentResource;
import com.api.lhs.appointment.resource.UpdateAppointmentResource;
import com.api.lhs.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class AppointmentMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public AppointmentResource toResource(Appointment model){
        return mapper.map(model, AppointmentResource.class);
    }
    public List<AppointmentResource> toResource(List<Appointment>model){
        return mapper.mapList(model, AppointmentResource.class);
    }
    public Appointment toModel(CreateAppointmentResource resource){
        return mapper.map(resource, Appointment.class);
    }
    public Appointment toModel(UpdateAppointmentResource resource){
        return mapper.map(resource, Appointment.class);
    }
}
