package com.api.lhs.ehr.resource;

import com.api.lhs.patient.resource.PatientResource;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PatientTreatmentResource {
    private Long id;
    private Date startDate;
    private Date endDate;
    private Float dose;
    private PatientResource patient;
    private TreatmentResource treatment;
    private MedicineResource medicine;
}
