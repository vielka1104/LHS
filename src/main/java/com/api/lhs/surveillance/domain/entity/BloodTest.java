package com.api.lhs.surveillance.domain.entity;

import com.api.lhs.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "blood_test")
public class BloodTest extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Float hemoglobin;

    @NotNull
    private Float lymphocytes;

    @NotNull
    private Float segmented;

    @NotNull
    private Float monocytes;

    @NotNull
    private Float mvc;

    @NotNull
    private Float mch;

    @NotNull
    private Float leukocytes;

    @NotNull
    private Float erythrocytes;

    @NotNull
    private Float glucose;

    @NotNull
    private Float cholesterol;

    @NotNull
    private Float urea;

    @NotNull
    private Float creatinine;
}
