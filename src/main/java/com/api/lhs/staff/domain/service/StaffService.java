package com.api.lhs.staff.domain.service;

import com.api.lhs.staff.domain.entity.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> getAll();
    Staff getById(Long adminId);
    Staff getByUserName(String username);
    Staff create(Staff staff);
    Staff update(Long adminId, Staff staff);
    Staff delete(Long adminId);
}
