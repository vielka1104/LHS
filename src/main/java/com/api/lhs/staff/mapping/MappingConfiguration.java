package com.api.lhs.staff.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("staffMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public StaffMapper staffMapper(){ return new StaffMapper(); }
}