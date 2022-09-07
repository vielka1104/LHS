package com.api.lhs.ehr.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("patientDiagnosisMappingConfiguration")
public class PatientDiagnosisMappingConfiguration {
    @Bean
    public PatientDiagnosisMapper patientDiagnosisMapper(){ return new PatientDiagnosisMapper(); }
}
