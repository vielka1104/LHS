package com.api.lhs.ehr.resource;

import com.api.lhs.patient.resource.PatientResource;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PatientTreatmentResource {
    private Long id;
    private PatientResource patient;
    private TreatmentResource treatment;
}
