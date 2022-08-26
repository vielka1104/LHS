package com.api.lhs.surveillance.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateNutritionResource {
    @NotNull
    @NotBlank
    private String plan;
}
