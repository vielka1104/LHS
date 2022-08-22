package com.api.lhs.appointment.resource;

import com.api.lhs.appointment.domain.entity.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateAppointmentResource {
    @NotNull
    @NotBlank
    private String notes;

    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
