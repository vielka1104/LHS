package com.api.lhs.doctor.api;

import com.api.lhs.doctor.domain.service.DoctorService;
import com.api.lhs.doctor.mapping.DoctorMapper;
import com.api.lhs.doctor.resource.CreateDoctorResource;
import com.api.lhs.doctor.resource.DoctorResource;
import com.api.lhs.doctor.resource.UpdateDoctorResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Doctor")
@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorMapper doctorMapper;

    @Operation(summary = "Get All Doctors", description = "Get All Doctors")
    @GetMapping("doctors")
    public List<DoctorResource> getAllDoctors(){
        return doctorMapper.toResource(doctorService.getAll());
    }

    @Operation(summary = "Get Doctor by Id", description = "Get Doctor by Id")
    @GetMapping("doctors/{doctorId}")
    public DoctorResource getDoctorById(@PathVariable Long doctorId){
        return doctorMapper.toResource(doctorService.getById(doctorId));
    }

    @Operation(summary = "Get Doctor by Username", description = "Get Doctor by Username")
    @GetMapping("doctors/username/{username}")
    public DoctorResource getDoctorByUserName(@PathVariable String username){
        return doctorMapper.toResource(doctorService.getByUserName(username));
    }

    @Operation(summary = "Get Doctor by Email", description = "Get Doctor by Email")
    @GetMapping("doctors/email/{email}")
    public DoctorResource getDoctorByEmail(@PathVariable String email){
        return doctorMapper.toResource(doctorService.getByEmail(email));
    }

    @Operation(summary = "Get Doctor by Dni", description = "Get Doctor by Dni")
    @GetMapping("doctors/dni/{dni}")
    public DoctorResource getDoctorByDni(@PathVariable String dni){
        return doctorMapper.toResource(doctorService.getByDni(dni));
    }

    @Operation(summary = "Get Doctor by Complete Name", description = "Get Doctor by Complete Name")
    @GetMapping("doctors/name/{name}/lastName/{lastName}")
    public List<DoctorResource> getDoctorByFirstNameAndLastName(@PathVariable String name, @PathVariable String lastName){
        return doctorMapper.toResource(doctorService.getByNameAndLastName(name, lastName));
    }

    @Operation(summary = "Create New Doctor", description = "Create New Doctor")
    @PostMapping("specialties/{specialtyId}/shifts/{shiftId}/doctors")
    public DoctorResource createDoctor(@RequestBody CreateDoctorResource model, @PathVariable Long specialtyId, @PathVariable Long shiftId){
        return doctorMapper.toResource(doctorService.create(doctorMapper.toModel(model), specialtyId, shiftId));
    }

    @Operation(summary = "Update Doctor", description = "Update Doctor")
    @PutMapping("doctors/{doctorId}")
    public DoctorResource updateDoctor(@PathVariable Long doctorId, @RequestBody UpdateDoctorResource model){
        return doctorMapper.toResource(doctorService.update(doctorId, doctorMapper.toModel(model)));
    }

    @Operation(summary = "Delete Doctor", description = "Delete Doctor")
    @DeleteMapping("doctors/{doctorId}")
    public void deleteDoctor(@PathVariable Long doctorId){
        doctorService.delete(doctorId);
    }
}
