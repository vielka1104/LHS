package com.api.lhs.patient.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("patientMappingConfiguration")
public class PatientMappingConfiguration {
    @Bean
    public PatientMapper patientMapper(){ return new PatientMapper(); }
}
