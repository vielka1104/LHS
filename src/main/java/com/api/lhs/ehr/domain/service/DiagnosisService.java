package com.api.lhs.ehr.domain.service;

import com.api.lhs.ehr.domain.entity.Diagnosis;

import java.util.List;

public interface DiagnosisService {
    List<Diagnosis> getAll();
    Diagnosis getById(Long diagnosisId);
    List<Diagnosis> getDiagnosisByName(String name);
    Diagnosis create(Diagnosis request);
    Diagnosis update(Long diagnosisId, Diagnosis request);
    Diagnosis delete(Long diagnosisId);
}
