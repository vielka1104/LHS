package com.api.lhs.appointment.domain.persistence;

import com.api.lhs.appointment.domain.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatient_Id(Long patientId);
    List<Appointment> findByDoctor_Id(Long doctorId);
    List<Appointment> findByStaff_Id(Long staffId);
    List<Appointment> findByPatient_IdAndDoctor_Id(Long patientId, Long doctorId);
    List<Appointment> findByScheduledAtGreaterThanEqualAndDoctor_Id(Date scheduledAt, Long doctorId);
}
