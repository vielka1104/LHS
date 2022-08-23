package com.api.lhs.doctor.mapping;

import com.api.lhs.doctor.mapping.SpecialtyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("specialtyMappingConfiguration")
public class SpecialtyMappingConfiguration {
    @Bean
    public SpecialtyMapper specialtyMapper(){ return new SpecialtyMapper(); }
}
