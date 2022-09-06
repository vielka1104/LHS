package com.api.lhs.patient.resource;

import com.api.lhs.patient.domain.entity.DocumentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class CreatePatientResource {
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
}
