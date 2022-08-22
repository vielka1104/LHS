package com.api.lhs.specialty.mapping;

import com.api.lhs.patient.mapping.PatientMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("specialtyMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public SpecialtyMapper specialtyMapper(){ return new SpecialtyMapper(); }
}
