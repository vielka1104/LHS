package com.innova.LHS.jsons;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterPatientRest {
    private String name;
    private String lastName;
    private String birth;
    private String sex;
}
