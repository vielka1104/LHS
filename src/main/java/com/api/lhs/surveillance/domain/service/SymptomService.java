package com.api.lhs.surveillance.domain.service;

import com.api.lhs.surveillance.domain.entity.Symptom;

import java.util.List;

public interface SymptomService {
    List<Symptom> getAll();
    Symptom getById(Long symptomId);
    Symptom create(Symptom request);
    Symptom update(Long symptomId, Symptom request);
    Symptom delete(Long symptomId);
}
