package com.api.lhs.surveillance.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateSymptomResource {
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
