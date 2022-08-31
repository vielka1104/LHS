package com.api.lhs.surveillance.domain.entity;

import com.api.lhs.shared.domain.model.AuditModel;
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
@Table(name = "symptom")
public class Symptom extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String appetite;

    @NotNull
    @NotBlank
    private String pain;

    @NotNull
    @NotBlank
    private String weightVariation;

    @NotNull
    private String Other;
}
