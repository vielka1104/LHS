package com.api.lhs.patient.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("userMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public PatientMapper patientMapper(){ return new PatientMapper(); }
}
