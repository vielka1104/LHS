package com.api.lhs.shift.service;

import com.api.lhs.shift.domain.entity.Schedule;
import com.api.lhs.shift.domain.persistence.ScheduleRepository;
import com.api.lhs.shift.domain.service.ScheduleService;
import com.api.lhs.shared.exception.ResourceNotFoundException;
import com.api.lhs.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final static String ENTITY = "Schedule";

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule getById(Long scheduleId) {
        return scheduleRepository.findById(scheduleId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, scheduleId));
    }

    @Override
    public List<Schedule> getSchedulesBetweenDates(Date startDate, Date endDate) {
        return scheduleRepository.findByStartHourGreaterThanEqualAndEndHourLessThanEqual(startDate, endDate);
    }

    @Override
    public Schedule create(Schedule request) {
        try{
            return scheduleRepository.save(request);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while saving schedule");
        }
    }

    @Override
    public Schedule update(Long scheduleId, Schedule request) {
        try{
            return scheduleRepository.findById(scheduleId).map(schedule -> scheduleRepository.save(
                    schedule.withStartHour(request.getStartHour())
                            .withEndHour(request.getEndHour())
            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, scheduleId));
        }catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating schedule");
        }
    }

    @Override
    public Schedule delete(Long scheduleId) {
        return scheduleRepository.findById(scheduleId).map(schedule -> {
            scheduleRepository.delete(schedule);
            return schedule;
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, scheduleId));
    }
}
