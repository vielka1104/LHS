package com.api.lhs.ehr.domain.service;

import com.api.lhs.ehr.domain.entity.IllnessRecord;

import java.util.List;

public interface IllnessRecordService {
    List<IllnessRecord> getAll();
    IllnessRecord getById(Long illnessRecordId);
    List<IllnessRecord> getIllnessRecordsByPatientId(Long patientId);
    List<IllnessRecord> getIllnessRecordsByPatientIdAndName(Long patientId, String name);
    IllnessRecord create(IllnessRecord request, Long patientId);
    IllnessRecord update(Long illnessRecordId, IllnessRecord request);
    IllnessRecord delete(Long illnessRecordId);
}
