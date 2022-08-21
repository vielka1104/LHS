package com.api.lhs.appointment.resource;

import com.api.lhs.appointment.domain.entity.Status;
import com.api.lhs.doctor.domain.entity.Doctor;
import com.api.lhs.patient.domain.entity.Patient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentResource {
    private Long id;
    private String notes;
    private Status status;
    private Patient patient;
    private Doctor doctor;
}
