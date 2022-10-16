package com.api.lhs.appointment.domain.service;

import com.api.lhs.appointment.domain.entity.Appointment;

import java.util.Date;
import java.util.List;

public interface AppointmentService {
    List<Appointment> getAll();
    Appointment getById(Long appointmentId);
    Appointment create(Appointment appointment, Long patientId, Long doctorId);
    Appointment update(Long appointmentId, Appointment appointment);
    Appointment rate(Long appointmentId, Integer rating);
    Appointment delete(Long appointmentId);
    List<Appointment> getByPatientId(Long patientId);
    List<Appointment> getByDoctorId(Long doctorId);
    List<Appointment> getByPatientIdAndDoctorId(Long patientId, Long doctorId);
    List<Appointment> getByScheduledDateAndDoctor(Date scheduleDate, Long doctorId);
}
