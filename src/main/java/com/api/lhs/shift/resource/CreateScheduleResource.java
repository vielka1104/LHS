package com.api.lhs.shift.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class CreateScheduleResource {
    @NotNull
    private Date startHour;

    @NotNull
    private Date endHour;
}
