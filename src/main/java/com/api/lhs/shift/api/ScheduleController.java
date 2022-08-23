package com.api.lhs.shift.api;

import com.api.lhs.shift.domain.service.ScheduleService;
import com.api.lhs.shift.mapping.ScheduleMapper;
import com.api.lhs.shift.resource.CreateScheduleResource;
import com.api.lhs.shift.resource.ScheduleResource;
import com.api.lhs.shift.resource.UpdateScheduleResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Tag(name = "Schedule")
@RestController
@RequestMapping("api/v1/schedules")
@CrossOrigin
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    
    @Autowired
    private ScheduleMapper scheduleMapper;

    @Operation(summary = "Get All Schedules", description = "Get All Schedules")
    @GetMapping
    public List<ScheduleResource> getAllSchedules(){
        return scheduleMapper.toResource(scheduleService.getAll());
    }

    @Operation(summary = "Get Schedule by Id", description = "Get Schedule by Id")
    @GetMapping("{scheduleId}")
    public ScheduleResource getScheduleById(@PathVariable Long scheduleId){
        return scheduleMapper.toResource(scheduleService.getById(scheduleId));
    }

    @Operation(summary = "Get Schedules Between Dates", description = "Get Schedules Between Dates")
    @GetMapping("startDate/{startDate}/endDate/{endDate}")
    public List<ScheduleResource> getScheduleByUserName(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date startDate, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date endDate){
        return scheduleMapper.toResource(scheduleService.getSchedulesBetweenDates(startDate, endDate));
    }

    @Operation(summary = "Create New Schedule", description = "Create New Schedule")
    @PostMapping
    public ScheduleResource createSchedule(@RequestBody CreateScheduleResource model){
        return scheduleMapper.toResource(scheduleService.create(scheduleMapper.toModel(model)));
    }

    @Operation(summary = "Update Schedule", description = "Update Schedule")
    @PutMapping("{scheduleId}")
    public ScheduleResource updateSchedule(@PathVariable Long scheduleId, @RequestBody UpdateScheduleResource model){
        return scheduleMapper.toResource(scheduleService.update(scheduleId, scheduleMapper.toModel(model)));
    }

    @Operation(summary = "Delete Schedule", description = "Delete Schedule")
    @DeleteMapping("{scheduleId}")
    public void deleteSchedule(@PathVariable Long scheduleId){
        scheduleService.delete(scheduleId);
    }
}
