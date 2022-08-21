package com.api.lhs.appointment.api;

import com.api.lhs.appointment.domain.service.AppointmentService;
import com.api.lhs.appointment.mapping.AppointmentMapper;
import com.api.lhs.appointment.resource.AppointmentResource;
import com.api.lhs.appointment.resource.CreateAppointmentResource;
import com.api.lhs.appointment.resource.UpdateAppointmentResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Appointment")
@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Operation(summary = "Get All Appointments", description = "Get All Appointments")
    @GetMapping("appointments")
    public List<AppointmentResource> getAll(){
        return appointmentMapper.toResource(appointmentService.getAll());
    }

    @Operation(summary = "Get Appointment by Id", description = "Get Appointment by Id")
    @GetMapping("appointments/{appointmentId}")
    public AppointmentResource getAppointmentById(@PathVariable Long appointmentId){
        return appointmentMapper.toResource(appointmentService.getById(appointmentId));
    }

    @Operation(summary = "Get Appointments by PatientId", description = "Get All Appointments by PatientId")
    @GetMapping("patients/{patientId}/appointments")
    public List<AppointmentResource> getAppointmentsByPatientId(@PathVariable Long patientId){
        return appointmentMapper.toResource(appointmentService.getByPatientId(patientId));
    }

    @Operation(summary = "Get Appointments by DoctorId", description = "Get All Appointments by DoctorId")
    @GetMapping("doctors/{doctorId}/appointments")
    public List<AppointmentResource> getAppointmentsByDoctorId(@PathVariable Long doctorId){
        return appointmentMapper.toResource(appointmentService.getByPatientId(doctorId));
    }

    @Operation(summary = "Get Appointments by PatientId and DoctorId", description = "Get All Appointments by PatientId and DoctorId")
    @GetMapping("patients/{patientId}/doctors/{doctorId}/appointments")
    public List<AppointmentResource> getAppointmentsByPatientIdAndDoctorId(@PathVariable Long patientId, @PathVariable Long doctorId){
        return appointmentMapper.toResource(appointmentService.getByPatientIdAndDoctorId(patientId, doctorId));
    }

    @Operation(summary = "Create New Appointment", description = "Create New Appointment")
    @PostMapping("patients/{patientId}/doctors/{doctorId}/appointments")
    public AppointmentResource createAppointment(@RequestBody CreateAppointmentResource model, @PathVariable Long patientId, @PathVariable Long doctorId, @PathVariable Long applianceId){
        return appointmentMapper.toResource(appointmentService.create(appointmentMapper.toModel(model), patientId, doctorId));
    }

    @Operation(summary = "Update Appointment", description = "Update Appointment")
    @PutMapping("appointments/{appointmentId}")
    public AppointmentResource updateAppointment(@PathVariable Long appointmentId, @RequestBody UpdateAppointmentResource model){
        return appointmentMapper.toResource(appointmentService.update(appointmentId, appointmentMapper.toModel(model)));
    }

    @Operation(summary = "Delete Appointment", description = "Delete Appointment")
    @DeleteMapping("{appointmentId}")
    public void deleteAppointment(@PathVariable Long appointmentId){
        appointmentService.delete(appointmentId);
    }
}
