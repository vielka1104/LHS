package com.api.lhs.shift.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("scheduleMappingConfiguration")
public class ScheduleMappingConfiguration {
    @Bean
    public ScheduleMapper scheduleMapper(){ return new ScheduleMapper(); }
}
