package com.api.lhs.staff.service;

import com.api.lhs.staff.domain.entity.Staff;
import com.api.lhs.staff.domain.persistence.StaffRepository;
import com.api.lhs.staff.domain.service.StaffService;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    private final static String ENTITY = "Staff";

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<Staff> getAll() {
        return staffRepository.findAll();
    }

    @Override
    public Staff getById(Long staffId) {
        return staffRepository.findById(staffId).orElseThrow(()-> new ResourceNotFoundException(ENTITY, staffId));
    }

    @Override
    public Staff getByUserName(String username) {
        return staffRepository.findByUsername(username);
    }

    @Override
    public Staff create(Staff request) {
        try{
            return staffRepository.save(request);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while saving staff");
        }
    }

    @Override
    public Staff update(Long staffId, Staff request) {
        try{
            return staffRepository.findById(staffId).map(staff -> staffRepository.save(
                    staff.withName(request.getName())
                            .withLastname(request.getLastname())
                            .withDni(request.getDni())
                            .withGender(request.getGender())
                            .withEmail(request.getEmail())
                            .withPhone(request.getPhone())
                            .withRole(request.getRole())
                            .withUsername(request.getUsername())
                            .withPassword(request.getPassword())
            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, staffId));
        }catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating staff");
        }
    }

    @Override
    public Staff delete(Long staffId) {
        return staffRepository.findById(staffId).map(staff -> {
            staffRepository.delete(staff);
            return staff;
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, staffId));
    }
}
