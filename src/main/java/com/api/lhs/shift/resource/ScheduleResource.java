package com.api.lhs.shift.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ScheduleResource {
    private Long id;
    private Date startHour;
    private Date endHour;
}
