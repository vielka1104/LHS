package com.api.lhs.shared.service;

import com.api.lhs.doctor.domain.persistence.DoctorRepository;
import com.api.lhs.patient.domain.persistence.PatientRepository;
import com.api.lhs.shared.domain.service.SharedService;
import com.api.lhs.staff.domain.persistence.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SharedServiceImpl implements SharedService {
    private final static String ENTITY = "Patient";
    private final static String ENTITY2 = "Doctor";
    private final static String ENTITY3 = "Staff";

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Object login(String username, String password) {
        var patient = patientRepository.findByUsername(username);
        if(patient != null && patient.getPassword().equals(password))
            return patient;

        var doctor = doctorRepository.findByUsername(username);
        if(doctor != null && doctor.getPassword().equals(password))
            return doctor;

        var staff = staffRepository.findByUsername(username);
        if(staff != null && staff.getPassword().equals(password))
            return staff;

        return null;
    }
}
