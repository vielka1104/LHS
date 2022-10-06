package com.api.lhs.ehr.resource;

import com.api.lhs.patient.resource.PatientResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientMedicineResource {
    private Long id;
    private Integer quantity;
    private String frequency;
    private PatientResource patient;
    private MedicineResource medicine;
}
