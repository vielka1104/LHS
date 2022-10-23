package com.api.lhs.patient.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("predictionMappingConfiguration")
public class PredictionMappingConfiguration {
    @Bean
    public PredictionMapper predictionMapper(){ return new PredictionMapper(); }
}
