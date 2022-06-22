package com.innova.LHS.services.impl;

import com.innova.LHS.dtos.StaffDto;
import com.innova.LHS.entities.Staff;
import com.innova.LHS.exceptions.InternalServerErrorException;
import com.innova.LHS.exceptions.LHSException;
import com.innova.LHS.jsons.RegisterStaffRest;
import com.innova.LHS.repositories.StaffRepository;
import com.innova.LHS.services.StaffService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffRepository staffRepository;
    public static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public StaffDto registerStaff(RegisterStaffRest registerStaffRest) throws LHSException {
        Staff staffEntity;
        Staff staff = new Staff();
        staff.setName(registerStaffRest.getName());
        staff.setLastName(registerStaffRest.getLastName());
        staff.setCellphone(registerStaffRest.getCellphone());
        staff.setAddress(registerStaffRest.getAddress());
        try{
            staffEntity = staffRepository.save(staff);
        }catch (final Exception e){
            throw new InternalServerErrorException("Error! No se pudo registrar al personal");
        }
        return modelMapper.map(staffEntity,StaffDto.class);
    }
}
