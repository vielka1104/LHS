package com.api.lhs.medicalCare.resource;

import com.api.lhs.medicalCare.domain.entity.DialysisMaterial;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateMedicalCareResource {
    @NotNull
    private Float ureaPre;
    @NotNull
    private Float ureaPost;
    @NotNull
    private Float dryWeight;
    @NotNull
    private Float initialWeight;
    @NotNull
    private Float finalWeight;
    @NotNull
    private Float hdTime;
    @NotNull
    private Float uf;
    @NotNull
    private Float ktv;
    @NotNull
    private Float hb;
    @NotNull
    private Float hto;
    @Enumerated(EnumType.ORDINAL)
    private DialysisMaterial dialysisMaterial;
}
