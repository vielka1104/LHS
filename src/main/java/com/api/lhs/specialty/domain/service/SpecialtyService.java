package com.api.lhs.specialty.domain.service;

import com.api.lhs.specialty.domain.entity.Specialty;

import java.util.List;

public interface SpecialtyService {
    List<Specialty> getAll();
    Specialty getById(Long specialtyId);
    List<Specialty> getByName(String name);
    Specialty create(Specialty request);
    Specialty update(Long specialtyId, Specialty request);
    Specialty delete(Long specialtyId);
}
