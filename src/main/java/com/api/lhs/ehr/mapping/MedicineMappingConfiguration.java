package com.api.lhs.ehr.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("medicineMappingConfiguration")
public class MedicineMappingConfiguration {
    @Bean
    public MedicineMapper medicineMapper(){ return new MedicineMapper(); }
}
