package com.api.lhs.doctor.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("doctorMappingConfiguration")
public class DoctorMappingConfiguration {
    @Bean
    public DoctorMapper doctorMapper() { return new DoctorMapper(); }
}
