package com.api.lhs.doctor.service;

import com.api.lhs.doctor.domain.entity.Doctor;
import com.api.lhs.doctor.domain.persistence.DoctorRepository;
import com.api.lhs.doctor.domain.persistence.ShiftRepository;
import com.api.lhs.doctor.domain.service.DoctorService;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.shared.exception.ResourceValidationException;
import com.api.lhs.doctor.domain.persistence.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final static String ENTITY = "Doctor";
    private final static String ENTITY2 = "Specialty";
    private final static String ENTITY3 = "Shift";
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private SpecialtyRepository specialtyRepository;
    @Autowired
    private ShiftRepository shiftRepository;

    @Autowired
    private Validator validator;
    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getById(Long doctorId) {
        return doctorRepository.findById(doctorId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,doctorId));
    }

    @Override
    public Doctor getByUserName(String username) {
        return doctorRepository.findByUsername(username);
    }

    @Override
    public Doctor getByEmail(String email) {
        return doctorRepository.findByEmail(email);
    }

    @Override
    public List<Doctor> getByNameAndLastName(String name, String lastName) {
        return doctorRepository.findByNameAndLastnameContaining(name, lastName);
    }

    @Override
    public Doctor create(Doctor request, Long specialtyId, Long shiftId) {
        var specialty = specialtyRepository.findById(specialtyId);
        if(specialty.isEmpty())
            throw new ResourceNotFoundException(ENTITY2, specialtyId);

        var shift = shiftRepository.findById(shiftId);
        if(shift.isEmpty())
            throw new ResourceNotFoundException(ENTITY3, shiftId);

        request.setSpecialty(specialty.get());
        request.setShift(shift.get());

        return doctorRepository.save(request);
    }

    @Override
    public Doctor update(Long doctorId, Doctor request) {
        try{
            return doctorRepository.findById(doctorId).map(doctor -> doctorRepository.save(
                    doctor.withName(request.getName())
                            .withLastname(request.getLastname())
                            .withGender(request.getGender())
                            .withDni(request.getDni())
                            .withAddress(request.getAddress())
                            .withEmail(request.getEmail())
                            .withPhone(request.getPhone())
                            .withUsername(request.getUsername())
                            .withPassword(request.getPassword())
            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, doctorId));
        }catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating doctor");
        }
    }

    @Override
    public Doctor delete(Long doctorId) {
        return doctorRepository.findById(doctorId).map(doctor -> {
            doctorRepository.delete(doctor);
            return doctor;
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, doctorId));
    }
}
