package com.api.lhs.surveillance.domain.entity;

import com.api.lhs.doctor.domain.entity.Doctor;
import com.api.lhs.patient.domain.entity.Patient;
import com.api.lhs.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "surveillance")
public class Surveillance extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Doctor doctor;

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

    // Legacy
    private Integer planCalories;
    private Integer consumedCalories;
    private String pain;
    private String otherSymptoms;
    private Float imc;
}
