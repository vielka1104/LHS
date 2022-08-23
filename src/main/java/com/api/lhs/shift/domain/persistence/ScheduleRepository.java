package com.api.lhs.shift.domain.persistence;

import com.api.lhs.shift.domain.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByStartHourGreaterThanEqualAndEndHourLessThanEqual(Date startHour, Date endHour);
}
