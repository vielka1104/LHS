package com.api.lhs.appointment.resource;

import com.api.lhs.appointment.domain.entity.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class UpdateAppointmentResource {
    @NotNull
    @NotBlank
    private String notes;

    @NotNull
    private Date scheduledAt;

    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
