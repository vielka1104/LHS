package com.api.lhs.surveillance.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateBloodTestResource {
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
    private Float leukocytesAndRedBloodCells;

    @NotNull
    private Float glucose;

    @NotNull
    private Float cholesterol;

    @NotNull
    private Float ureaAndCreatinine;
}
