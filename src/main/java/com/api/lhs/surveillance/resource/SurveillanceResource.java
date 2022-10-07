package com.api.lhs.surveillance.resource;

import com.api.lhs.doctor.resource.DoctorResource;
import com.api.lhs.patient.resource.PatientResource;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SurveillanceResource {
    private Long id;
    private PatientResource patient;
    // Calculate ktv
    @NotNull
    private Float initWeight;
    private Float finalWeight;
    private Float hdTime;
    private Float uf;

    // Clinic
    private Float ureaPre;
    private Float serumElectrolytes;
    private Float chlorine;
    private Float phosphorus;
    private Float serumCalcium;
    private Float proteinElectrophoresis;
    private Float alkalinePhosphatase;
    private Float tgo;
    private Float tgp;
    private Float dayCreatinine;
    private Float parathormone;
    private Float serumIron;
    private Float serumFerritin;
    private Float transferrinSaturation;
    private Float transferrin;
    private Boolean elisa;
    private Boolean vdrlAndRpr;
    private Boolean hepatitisBAntigen;
    private Boolean hepatitisBAntibody;
    private Boolean hepatitisCAntibody;
    private Float ktv;

    // Shared
    private Float bloodUrea; // este es el postUrea
    private Float serumCreatinine; // este es creatinina
    private Float packedCellVolume; // hematocritos en front
    private Float hemoglobin;
    private Float sodium;
    private Float potassium;
    private Float albumin;

    // Prediction
    private Float bloodPressure;
    private Float specificGravity;
    private Float sugar;
    private Boolean redBloodCells;
    private Boolean pusCells;
    private Boolean pusCellClumps;
    private Boolean bacteria;
    private Float bloodGlucoseRandom;
    private Float whiteBloodCellCount;
    private Float redBloodCellCount;
    private Boolean appetite;
    private Boolean pedalEdema;

    // Legacy
    private Integer planCalories;
    private Integer consumedCalories;
    private String pain;
    private String otherSymptoms;
    private Float imc;
}
