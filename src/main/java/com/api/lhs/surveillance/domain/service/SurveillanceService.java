package com.api.lhs.surveillance.domain.service;

import com.api.lhs.surveillance.domain.entity.Surveillance;

import java.util.List;

public interface SurveillanceService {
    List<Surveillance> getAll();
    Surveillance getById(Long surveillanceId);
    List<Surveillance> getByPatientId(Long patientId);
    Surveillance create(Surveillance request, Long patientId);
    Surveillance update(Long surveillanceId, Surveillance request);
    Surveillance delete(Long surveillanceId);
}
