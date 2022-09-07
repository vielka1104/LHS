package com.api.lhs.ehr.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class CreatePatientDiagnosisResource {
    @NotNull
    private Date startDate;

    private Date endDate;
}
