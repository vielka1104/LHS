package com.api.lhs.admin.mapping;

import com.api.lhs.patient.mapping.PatientMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("adminMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public AdminMapper adminMapper(){ return new AdminMapper(); }
}