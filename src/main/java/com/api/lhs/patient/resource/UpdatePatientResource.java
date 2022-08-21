package com.api.lhs.patient.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class UpdatePatientResource {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String lastname;

    @NotNull
    private Date birthday;

    @NotNull
    private String gender;

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
}