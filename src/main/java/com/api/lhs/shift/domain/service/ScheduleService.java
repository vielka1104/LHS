package com.api.lhs.shift.domain.service;

import com.api.lhs.shift.domain.entity.Schedule;

import java.util.Date;
import java.util.List;

public interface ScheduleService {
    List<Schedule> getAll();
    Schedule getById(Long scheduleId);
    List<Schedule> getSchedulesBetweenDates(Date startDate, Date endDate);
    Schedule create(Schedule request);
    Schedule update(Long scheduleId, Schedule request);
    Schedule delete(Long scheduleId);
}
