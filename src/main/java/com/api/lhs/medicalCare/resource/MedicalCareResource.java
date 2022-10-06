package com.api.lhs.medicalCare.resource;

import com.api.lhs.medicalCare.domain.entity.DialysisMaterial;
import com.api.lhs.patient.resource.PatientResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicalCareResource {
    private Long id;
    private PatientResource patient;
    private Float ureaPre;
    private Float ureaPost;
    private Float dryWeight;
    private Float initialWeight;
    private Float finalWeight;
    private Float hdTime;
    private Float uf;
    private Float ktv;
    private Float hb;
    private Float hto;
    private DialysisMaterial dialysisMaterial;
}
