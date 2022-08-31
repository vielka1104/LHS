package com.api.lhs.surveillance.domain.service;

import com.api.lhs.surveillance.domain.entity.BloodTest;

import java.util.List;

public interface BloodTestService {
    List<BloodTest> getAll();
    BloodTest getById(Long bloodTestId);
    BloodTest create(BloodTest request);
    BloodTest update(Long bloodTestId, BloodTest request);
    BloodTest delete(Long bloodTestId);
}
