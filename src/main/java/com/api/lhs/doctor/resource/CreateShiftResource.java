package com.api.lhs.doctor.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class CreateShiftResource {
    @NotNull
    @NotBlank
    private String name;

    @Temporal(TemporalType.TIME)
    private Date startShift;

    @Temporal(TemporalType.TIME)
    private Date endShift;

    @NotNull
    private Integer gapMinutes;
}
