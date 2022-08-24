package com.api.lhs.doctor.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("shiftMappingConfiguration")
public class ShiftMappingConfiguration {
    @Bean
    public ShiftMapper shiftMapper() { return new ShiftMapper(); }
}
