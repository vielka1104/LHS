package com.api.lhs.ehr.domain.service;

import com.api.lhs.ehr.domain.entity.Medicine;

import java.util.List;

public interface MedicineService {
    List<Medicine> getAll();
    Medicine getById(Long medicineId);
    List<Medicine> getMedicinesByName(String name);
    Medicine create(Medicine request);
    Medicine update(Long medicineId, Medicine request);
    Medicine delete(Long medicineId);
}
