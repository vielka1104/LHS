package com.api.lhs.doctor.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ShiftResource {
    private Long id;
    private String name;
    private Date startShift;
    private Date endShift;
    private Integer gapMinutes;
}
