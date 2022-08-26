package com.api.lhs.surveillance.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("nutritionMappingConfiguration")
public class NutritionMappingConfiguration {
    @Bean
    public NutritionMapper nutritionMapper(){ return new NutritionMapper(); }
}
