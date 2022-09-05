package com.api.lhs.ehr.domain.service;

import com.api.lhs.ehr.domain.entity.Treatment;

import java.util.List;

public interface TreatmentService {
    List<Treatment> getAll();
    Treatment getById(Long treatmentId);
    List<Treatment> getTreatmentsByName(String name);
    Treatment create(Treatment request);
    Treatment update(Long treatmentId, Treatment request);
    Treatment delete(Long treatmentId);
}
