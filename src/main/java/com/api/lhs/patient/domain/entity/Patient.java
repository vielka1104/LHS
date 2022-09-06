package com.api.lhs.patient.domain.entity;

import com.api.lhs.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "patient", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}),@UniqueConstraint(columnNames = {"phone"}),@UniqueConstraint(columnNames = {"email"}), @UniqueConstraint(columnNames = {"documentNumber"})})
public class Patient extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String lastname;

    @Enumerated(EnumType.ORDINAL)
    private DocumentType documentType;

    @NotNull
    @NotBlank
    private String documentNumber;

    @NotNull
    private Date birthday;

    @NotNull
    private String gender;

    @NotNull
    @NotBlank
    @Size(max=50)
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(max=9)
    private String phone;

    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    @Size(min=8,max=20)
    private String password;

    private String height;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "renal_disease_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private RenalDisease renalDisease;
}
