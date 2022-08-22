package com.api.lhs.admin.domain.service;

import com.api.lhs.admin.domain.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAll();
    Admin getById(Long adminId);
    Admin getByUserName(String username);
    Admin create(Admin admin);
    Admin update(Long adminId, Admin admin);
    Admin delete(Long adminId);
}
