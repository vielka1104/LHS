package com.api.lhs.patient.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("renalDiseaseMappingConfiguration")
public class RenalDiseaseMappingConfiguration {
    @Bean
    public RenalDiseaseMapper renalDiseaseMapper(){ return new RenalDiseaseMapper(); }
}
