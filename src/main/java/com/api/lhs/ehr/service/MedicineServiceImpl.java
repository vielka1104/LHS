package com.api.lhs.ehr.service;

import com.api.lhs.ehr.domain.entity.Medicine;
import com.api.lhs.ehr.domain.persistence.MedicineRepository;
import com.api.lhs.ehr.domain.service.MedicineService;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {
    private final static String ENTITY = "Medicine";
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private Validator validator;

    @Override
    public List<Medicine> getAll() {
        return medicineRepository.findAll();
    }

    @Override
    public Medicine getById(Long medicineId) {
        return medicineRepository.findById(medicineId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, medicineId));
    }

    @Override
    public List<Medicine> getMedicinesByName(String name) {
        return medicineRepository.findByNameContains(name);
    }

    @Override
    public Medicine create(Medicine request) {
        try{
            return medicineRepository.save(request);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while saving medicine");
        }
    }

    @Override
    public Medicine update(Long medicineId, Medicine request) {
        try{
            return medicineRepository.findById(medicineId).map(medicine -> medicineRepository.save(
                    medicine.withName(request.getName())
            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, medicineId));
        }catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating medicine");
        }
    }

    @Override
    public Medicine delete(Long medicineId) {
        return medicineRepository.findById(medicineId).map(medicine -> {
            medicineRepository.delete(medicine);
            return medicine;
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, medicineId));
    }
}
