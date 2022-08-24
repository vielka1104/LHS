package com.api.lhs.appointment.resource;

import com.api.lhs.admin.resource.AdminResource;
import com.api.lhs.appointment.domain.entity.Status;
import com.api.lhs.doctor.resource.DoctorResource;
import com.api.lhs.patient.resource.PatientResource;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AppointmentResource {
    private Long id;
    private String notes;
    private Date scheduledAt;
    private Status status;
    private PatientResource patient;
    private DoctorResource doctor;
    private AdminResource admin;
}
