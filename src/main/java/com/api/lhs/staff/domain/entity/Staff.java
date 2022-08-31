package com.api.lhs.staff.domain.entity;

import com.api.lhs.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "staff", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}), @UniqueConstraint(columnNames = {"phone"}), @UniqueConstraint(columnNames = {"email"}), @UniqueConstraint(columnNames = {"dni"})})
public class Staff extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String lastname;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 8)
    private String dni;

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

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    @Size(min=8,max=20)
    private String password;
}
