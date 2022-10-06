package com.api.lhs.doctor.domain.service;

import com.api.lhs.doctor.domain.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAll();
    Doctor getById(Long doctorId);
    Doctor getByUserName(String username);
    Doctor getByEmail(String email);
    Doctor getByDni(String dni);
    List<Doctor> getByNameAndLastName(String name, String lastName);
    Doctor create(Doctor doctor, Long specialtyId, Long shiftId);
    Doctor update(Long doctorId, Doctor doctor);
    Doctor delete(Long doctorId);
}
