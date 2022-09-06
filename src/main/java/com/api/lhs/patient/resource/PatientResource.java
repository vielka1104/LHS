package com.api.lhs.patient.resource;

import com.api.lhs.patient.domain.entity.DocumentType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PatientResource {
    private Long id;
    private String name;
    private String lastname;
    private DocumentType documentType;
    private String documentNumber;
    private Date birthday;
    private String gender;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String height;
    private RenalDiseaseResource renalDisease;
}
