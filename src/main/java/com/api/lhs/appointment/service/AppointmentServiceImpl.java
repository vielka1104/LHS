package com.api.lhs.appointment.service;

import com.api.lhs.appointment.domain.entity.Appointment;
import com.api.lhs.appointment.domain.persistence.AppointmentRepository;
import com.api.lhs.appointment.domain.service.AppointmentService;
import com.api.lhs.doctor.domain.persistence.DoctorRepository;
import com.api.lhs.patient.domain.persistence.PatientRepository;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final static String ENTITY = "Appointment";
    private final static String ENTITY2 = "Patient";
    private final static String ENTITY3 = "Doctor";

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;


    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public Appointment create(Appointment request, Long patientId, Long doctorId) {
        var patient = patientRepository.findById(patientId);
        if(patient.isEmpty())
            throw new ResourceNotFoundException(ENTITY2, patientId);

        var doctor = doctorRepository.findById(doctorId);
        if(doctor.isEmpty())
            throw new ResourceNotFoundException(ENTITY3, doctorId);

        request.setPatient(patient.get());
        request.setDoctor(doctor.get());

        return appointmentRepository.save(request);
    }

    @Override
    public Appointment update(Long appointmentId, Appointment request) {
        return appointmentRepository.findById(appointmentId)
                .map(appointment -> appointmentRepository.save(
                        appointment.withNotes(request.getNotes())
                                .withStatus(request.getStatus())
                )).orElseThrow(() -> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public Appointment delete(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .map(appointment -> {
                    appointmentRepository.delete(appointment);
                    return appointment;
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public List<Appointment> getByPatientId(Long patientId) {
        var patient = patientRepository.findById(patientId);
        if(patient.isEmpty())
            throw new ResourceNotFoundException(ENTITY2, patientId);

        return appointmentRepository.findByPatient_Id(patientId);
    }

    @Override
    public List<Appointment> getByDoctorId(Long doctorId) {
        var doctor = doctorRepository.findById(doctorId);
        if(doctor.isEmpty())
            throw new ResourceNotFoundException(ENTITY3, doctorId);

        return appointmentRepository.findByDoctor_Id(doctorId);
    }

    @Override
    public List<Appointment> getByPatientIdAndDoctorId(Long patientId, Long doctorId) {
        var patient = patientRepository.findById(patientId);
        if(patient.isEmpty())
            throw new ResourceNotFoundException(ENTITY2, patientId);

        var doctor = doctorRepository.findById(doctorId);
        if(doctor.isEmpty())
            throw new ResourceNotFoundException(ENTITY3, doctorId);

        return appointmentRepository.findByPatient_IdAndDoctor_Id(patientId, doctorId);
    }

    @Override
    public List<Appointment> getByScheduledDateAndDoctor(Date scheduleDate, Long doctorId) {
        return appointmentRepository.findByScheduledAtGreaterThanEqualAndDoctor_Id(scheduleDate, doctorId);
    }
}
