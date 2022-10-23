package com.api.lhs.patient.domain.service;

import com.api.lhs.patient.domain.entity.Prediction;

import java.util.List;

public interface PredictionService {
    List<Prediction> getAll();
    Prediction getById(Long predictionId);
    Prediction getByPatientId(Long patientId);
    Prediction create(Long patientId, Prediction request);
    Prediction update(Long predictionId, Prediction request);
    Prediction delete(Long predictionId);
}
