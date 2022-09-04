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

    @NotNull
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
