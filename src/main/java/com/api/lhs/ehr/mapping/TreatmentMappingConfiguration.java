package com.api.lhs.ehr.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("treatmentMappingConfiguration")
public class TreatmentMappingConfiguration {
    @Bean
    public TreatmentMapper treatmentMapper(){ return new TreatmentMapper(); }
}
