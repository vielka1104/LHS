package com.api.lhs.patient.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreatePredictionResource {
    @NotNull
    private Float yes;

    @NotNull
    private Float no;

    @NotNull
    private Boolean outcome;
}
