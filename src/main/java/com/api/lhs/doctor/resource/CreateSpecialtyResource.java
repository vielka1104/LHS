package com.api.lhs.doctor.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateSpecialtyResource {
    @NotNull
    @NotBlank
    @Size(max=40)
    private String name;
}
