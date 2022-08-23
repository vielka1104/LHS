package com.api.lhs.doctor.service;

import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.shared.exception.ResourceValidationException;
import com.api.lhs.doctor.domain.entity.Specialty;
import com.api.lhs.doctor.domain.persistence.SpecialtyRepository;
import com.api.lhs.doctor.domain.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {
    private final static String ENTITY = "Specialty";

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<Specialty> getAll() {
        return specialtyRepository.findAll();
    }

    @Override
    public Specialty getById(Long specialtyId) {
        return specialtyRepository.findById(specialtyId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, specialtyId));
    }

    @Override
    public List<Specialty> getByName(String name) {
        return specialtyRepository.findSpecialtiesByNameContains(name);
    }

    @Override
    public Specialty create(Specialty request) {
        try{
            return specialtyRepository.save(request);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while saving specialty");
        }
    }

    @Override
    public Specialty update(Long specialtyId, Specialty request) {
        try{
            return specialtyRepository.findById(specialtyId).map(specialty -> specialtyRepository.save(
                    specialty.withName(request.getName())
            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, specialtyId));
        }catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating specialty");
        }
    }

    @Override
    public Specialty delete(Long specialtyId) {
        return specialtyRepository.findById(specialtyId).map(specialty -> {
            specialtyRepository.delete(specialty);
            return specialty;
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, specialtyId));
    }
}
