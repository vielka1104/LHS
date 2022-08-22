package com.api.lhs.admin.service;

import com.api.lhs.admin.domain.entity.Admin;
import com.api.lhs.admin.domain.persistence.AdminRepository;
import com.api.lhs.admin.domain.service.AdminService;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final static String ENTITY = "Admin";

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getById(Long adminId) {
        return adminRepository.findById(adminId).orElseThrow(()-> new ResourceNotFoundException(ENTITY, adminId));
    }

    @Override
    public Admin getByUserName(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public Admin create(Admin request) {
        try{
            return adminRepository.save(request);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while saving admin");
        }
    }

    @Override
    public Admin update(Long adminId, Admin request) {
        try{
            return adminRepository.findById(adminId).map(admin -> adminRepository.save(
                    admin.withUsername(request.getUsername())
                            .withPassword(request.getPassword())
            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, adminId));
        }catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating admin");
        }
    }

    @Override
    public Admin delete(Long adminId) {
        return adminRepository.findById(adminId).map(admin -> {
            adminRepository.delete(admin);
            return admin;
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, adminId));
    }
}
