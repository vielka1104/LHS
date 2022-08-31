package com.api.lhs.surveillance.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BloodTestResource {
    private Long id;
    private Float hemoglobin;
    private Float lymphocytes;
    private Float segmented;
    private Float monocytes;
    private Float mvc;
    private Float mch;
    private Float leukocytesAndRedBloodCells;
    private Float glucose;
    private Float cholesterol;
    private Float ureaAndCreatinine;
}
