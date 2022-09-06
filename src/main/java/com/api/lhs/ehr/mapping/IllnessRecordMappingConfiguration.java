package com.api.lhs.ehr.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("illnessRecordMappingConfiguration")
public class IllnessRecordMappingConfiguration {
    @Bean
    public IllnessRecordMapper illnessRecordMapper(){ return new IllnessRecordMapper(); }
}
