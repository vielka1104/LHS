package com.api.lhs.surveillance.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateSurveillanceResource {
    // Calculate ktv
    @NotNull
    private Float initWeight;
    private Float finalWeight;
    private Float hdTime;
    private Float uf;

    // Clinic
    private Float ureaPre;
    private Float hematocrit;
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
    private Float elisa;
    private Float vdrlAndRpr;
    private Float hepatitisBAntigen;
    private Float hepatitisBAntibody;
    private Float hepatitisCAntibody;
    private Float ktv;

    // Shared
    private Float bloodUrea; // este es el postUrea
    private Float serumCreatinine; // este es creatinina
    private Float hemoglobin;
    private Float sodium;
    private Float potassium;
    private Float albumin;

    // Prediction
    private Float bloodPressure;
    private Float specificGravity;
    private Float sugar;
    private Integer redBloodCells;
    private Integer pusCells;
    private Integer pusCellClumps;
    private Integer bacteria;
    private Float bloodGlucoseRandom;
    private Float packedCellVolume;
    private Float whiteBloodCellCount;
    private Float redBloodCellCount;
    private Integer appetite;
    private Integer pedalEdema;

    // Legacy
    private Integer planCalories;
    private Integer consumedCalories;
    private String pain;
    private String otherSymptoms;
    private Float imc;
}
