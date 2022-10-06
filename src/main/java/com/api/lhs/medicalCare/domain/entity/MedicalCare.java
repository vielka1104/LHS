package com.api.lhs.medicalCare.domain.entity;

import com.api.lhs.patient.domain.entity.Patient;
import com.api.lhs.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "medical_care")
public class MedicalCare extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Patient patient;

    @NotNull
    private Float ureaPre;
    @NotNull
    private Float ureaPost;
    @NotNull
    private Float dryWeight;
    @NotNull
    private Float initialWeight;
    @NotNull
    private Float finalWeight;
    @NotNull
    private Float hdTime;
    @NotNull
    private Float uf;
    @NotNull
    private Float ktv;
    @NotNull
    private Float hb;
    @NotNull
    private Float hto;
    @Enumerated(EnumType.ORDINAL)
    private DialysisMaterial dialysisMaterial;
}
