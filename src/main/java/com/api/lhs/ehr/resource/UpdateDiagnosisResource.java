package com.api.lhs.ehr.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateDiagnosisResource {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String description;
}
