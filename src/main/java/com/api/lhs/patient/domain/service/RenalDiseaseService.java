package com.api.lhs.patient.domain.service;

import com.api.lhs.patient.domain.entity.RenalDisease;

import java.util.List;

public interface RenalDiseaseService {
    List<RenalDisease> getAll();
    RenalDisease getById(Long renalDiseaseId);
    RenalDisease getByName(String name);
    RenalDisease create(RenalDisease request);
    RenalDisease update(Long renalDiseaseId, RenalDisease request);
    RenalDisease delete(Long renalDiseaseId);
}
