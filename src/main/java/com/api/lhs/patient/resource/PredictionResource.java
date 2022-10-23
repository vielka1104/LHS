package com.api.lhs.patient.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PredictionResource {
    private Long id;
    private Float yes;
    private Float no;
    private Boolean outcome;
    private PatientResource patient;
}
