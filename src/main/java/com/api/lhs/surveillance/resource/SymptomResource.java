package com.api.lhs.surveillance.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SymptomResource {
    private Long id;
    private String appetite;
    private String pain;
    private String weightVariation;
    private String Other;
}
