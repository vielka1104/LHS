package com.api.lhs.doctor.service;

import com.api.lhs.doctor.domain.entity.Shift;
import com.api.lhs.doctor.domain.persistence.ShiftRepository;
import com.api.lhs.doctor.domain.service.ShiftService;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class ShiftServiceImpl implements ShiftService {
    private final static String ENTITY = "Shift";

    @Autowired
    private ShiftRepository shiftRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<Shift> getAll() {
        return shiftRepository.findAll();
    }

    @Override
    public Shift getById(Long shiftId) {
        return shiftRepository.findById(shiftId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, shiftId));
    }

    @Override
    public List<Shift> getByName(String name) {
        return shiftRepository.findByNameContaining(name);
    }

    @Override
    public Shift create(Shift request) {
        try{
            return shiftRepository.save(request);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while saving shift");
        }
    }

    @Override
    public Shift update(Long shiftId, Shift request) {
        try{
            return shiftRepository.findById(shiftId).map(shift -> shiftRepository.save(
                    shift.withName(request.getName())
                            .withStartShift(request.getStartShift())
                            .withEndShift(request.getEndShift())
                            .withGapMinutes(request.getGapMinutes())
            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, shiftId));
        }catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating shift");
        }
    }

    @Override
    public Shift delete(Long shiftId) {
        return shiftRepository.findById(shiftId).map(shift -> {
            shiftRepository.delete(shift);
            return shift;
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, shiftId));
    }
}
