package com.innova.LHS.services.impl;

import com.innova.LHS.dtos.MedicDto;
import com.innova.LHS.entities.Medic;
import com.innova.LHS.exceptions.InternalServerErrorException;
import com.innova.LHS.exceptions.LHSException;
import com.innova.LHS.jsons.RegisterMedicRest;
import com.innova.LHS.repositories.MedicRepository;
import com.innova.LHS.services.MedicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicServiceImpl implements MedicService {

    @Autowired
    MedicRepository medicRepository;
    public static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public MedicDto registerMedic(RegisterMedicRest registerMedicRest) throws LHSException {
        Medic medicEntity;
        Medic medic = new Medic();
        medic.setName(registerMedicRest.getName());
        medic.setLastName(registerMedicRest.getLastName());
        medic.setCellphone(registerMedicRest.getCellphone());
        medic.setAddress(registerMedicRest.getAddress());
        try {
            medicEntity = medicRepository.save(medic);
        }catch (final Exception e){
            throw new InternalServerErrorException("Error! No se pudo registrar al medico");
        }
        return modelMapper.map(medicEntity,MedicDto.class);
    }
}
