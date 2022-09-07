package com.api.lhs.ehr.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("patientTreatmentMappingConfiguration")
public class PatientTreatmentMappingConfiguration {
    @Bean
    public PatientTreatmentMapper patientTreatmentMapper(){ return new PatientTreatmentMapper(); }
}
