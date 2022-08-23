package com.api.lhs.shift.mapping;

import com.api.lhs.shift.domain.entity.Schedule;
import com.api.lhs.shift.resource.CreateScheduleResource;
import com.api.lhs.shift.resource.ScheduleResource;
import com.api.lhs.shift.resource.UpdateScheduleResource;
import com.api.lhs.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ScheduleMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public ScheduleResource toResource(Schedule model) { return mapper.map(model, ScheduleResource.class); }
    public List<ScheduleResource> toResource(List<Schedule> model) { return  mapper.mapList(model, ScheduleResource.class); }
    public Schedule toModel(CreateScheduleResource resource) { return mapper.map(resource, Schedule.class); }
    public Schedule toModel(UpdateScheduleResource resource) { return mapper.map(resource, Schedule.class); }
}
