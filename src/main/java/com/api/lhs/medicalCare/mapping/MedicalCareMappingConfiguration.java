package com.api.lhs.medicalCare.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("medicalCareMappingConfiguration")
public class MedicalCareMappingConfiguration {
    @Bean
    public MedicalCareMapper medicalCareMapper() { return new MedicalCareMapper(); }
}
