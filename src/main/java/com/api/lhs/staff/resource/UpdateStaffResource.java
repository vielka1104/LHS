package com.api.lhs.staff.resource;

import com.api.lhs.staff.domain.entity.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateStaffResource {
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
