package com.api.lhs.surveillance.resource;

import com.api.lhs.doctor.resource.DoctorResource;
import com.api.lhs.patient.resource.PatientResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurveillanceResource {
    private Long id;
    private PatientResource patient;
    private DoctorResource doctor;
    private Float weight;
    private Float hemoglobin;
    private Float lymphocytes;
    private Float segmented;
    private Float monocytes;
    private Float mvc;
    private Float mch;
    private Float leukocytes;
    private Float erythrocytes;
    private Float glucose;
    private Float cholesterol;
    private Float urea;
    private Float creatinine;
    private Float density;
    private Float ph;
    private Float protein;
    private Float ketone;
    private Float urobilinogen;
    private Float bilirubin;
    private Float nitrite;
    private Float crystals;
    private Float sugar;
    private String urineAppearance;
    private String urineColor;
    private Integer planCalories;
    private Integer consumedCalories;
    private String appetite;
    private String pain;
    private String otherSymptoms;
    private Float imc;
}
