package com.api.lhs.doctor.domain.service;

import com.api.lhs.doctor.domain.entity.Shift;

import java.util.List;

public interface ShiftService {
    List<Shift> getAll();
    Shift getById(Long shiftId);
    List<Shift> getByName(String name);
    Shift create(Shift shift);
    Shift update(Long shiftId, Shift shift);
    Shift delete(Long shiftId);
}
