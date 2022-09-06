package com.api.lhs.ehr.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("diagnosisMappingConfiguration")
public class DiagnosisMappingConfiguration {
    @Bean
    public DiagnosisMapper diagnosisMapper(){ return new DiagnosisMapper(); }
}
