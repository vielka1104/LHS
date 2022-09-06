package com.api.lhs.ehr.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class CreateIllnessRecordResource {
    @NotNull
    @NotBlank
    private String illness;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    private Date date;
}
