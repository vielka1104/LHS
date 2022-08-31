package com.api.lhs.surveillance.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("bloodTestMappingConfiguration")
public class BloodTestMappingConfiguration {
    @Bean
    public BloodTestMapper bloodTestMapper() { return new BloodTestMapper(); }
}
