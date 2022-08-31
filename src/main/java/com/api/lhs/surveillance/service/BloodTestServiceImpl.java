package com.api.lhs.surveillance.service;

import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.shared.exception.ResourceValidationException;
import com.api.lhs.surveillance.domain.entity.BloodTest;
import com.api.lhs.surveillance.domain.persistence.BloodTestRepository;
import com.api.lhs.surveillance.domain.service.BloodTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class BloodTestServiceImpl implements BloodTestService {
    private final static String ENTITY = "BloodTest";
    @Autowired
    private BloodTestRepository bloodTestRepository;
    @Autowired
    private Validator validator;

    @Override
    public List<BloodTest> getAll() {
        return bloodTestRepository.findAll();
    }

    @Override
    public BloodTest getById(Long bloodTestId) {
        return bloodTestRepository.findById(bloodTestId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, bloodTestId));
    }

    @Override
    public BloodTest create(BloodTest request) {
        try{
            return bloodTestRepository.save(request);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while saving bloodTest");
        }
    }

    @Override
    public BloodTest update(Long bloodTestId, BloodTest request) {
        try{
            return bloodTestRepository.findById(bloodTestId).map(bloodTest -> bloodTestRepository.save(
                    bloodTest.withCholesterol(request.getCholesterol())
                            .withGlucose(request.getGlucose())
                            .withHemoglobin(request.getHemoglobin())
                            .withMch(request.getMch())
                            .withMvc(request.getMvc())
                            .withLeukocytesAndRedBloodCells(request.getLeukocytesAndRedBloodCells())
                            .withLymphocytes(request.getLymphocytes())
                            .withMonocytes(request.getMonocytes())
                            .withSegmented(request.getSegmented())
                            .withUreaAndCreatinine(request.getUreaAndCreatinine())
            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, bloodTestId));
        }catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating bloodTest");
        }
    }

    @Override
    public BloodTest delete(Long bloodTestId) {
        return bloodTestRepository.findById(bloodTestId).map(bloodTest -> {
            bloodTestRepository.delete(bloodTest);
            return bloodTest;
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, bloodTestId));
    }
}
