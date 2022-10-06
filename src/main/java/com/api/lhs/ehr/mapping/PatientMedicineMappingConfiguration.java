package com.api.lhs.ehr.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("patientMedicineMappingConfiguration")
public class PatientMedicineMappingConfiguration {
    @Bean
    public PatientMedicineMapper patientMedicineMapper(){ return new PatientMedicineMapper(); }
}
