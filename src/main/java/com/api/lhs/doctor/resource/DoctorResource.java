package com.api.lhs.doctor.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DoctorResource {
    private Long id;
    private String name;
    private String lastname;
    private String gender;
    private String dni;
    private String address;
    private String email;
    private String phone;
    private String username;
    private String password;
    private SpecialtyResource specialty;
    private ShiftResource shift;
}
