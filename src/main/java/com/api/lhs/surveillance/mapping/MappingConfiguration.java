package com.api.lhs.surveillance.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("surveillanceMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public SurveillanceMapper surveillanceMapper(){
        return new SurveillanceMapper();
    }
}
