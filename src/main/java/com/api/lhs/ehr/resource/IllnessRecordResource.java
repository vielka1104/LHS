package com.api.lhs.ehr.resource;

import com.api.lhs.patient.resource.PatientResource;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class IllnessRecordResource {
    private Long id;
    private String illness;
    private String description;
    private Date date;
    private PatientResource patient;
}
