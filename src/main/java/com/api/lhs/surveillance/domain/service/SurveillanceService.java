package com.api.lhs.surveillance.domain.service;

import com.api.lhs.surveillance.domain.entity.Surveillance;

import java.util.List;

public interface SurveillanceService {
    List<Surveillance> getAll();
    Surveillance getById(Long surveillanceId);
    List<Surveillance> getByPatientId(Long patientId);
    List<Surveillance> getByDoctorId(Long doctorId);
    List<Surveillance> getByPatientIdAndDoctorId(Long patientId, Long doctorId);
    Surveillance create(Surveillance request, Long patientId, Long doctorId);
    Surveillance update(Long surveillanceId, Surveillance request);
    Surveillance delete(Long surveillanceId);
}
