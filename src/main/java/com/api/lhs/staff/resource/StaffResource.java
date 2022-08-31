package com.api.lhs.staff.resource;

import com.api.lhs.staff.domain.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffResource {
    private Long id;
    private String name;
    private String lastname;
    private String dni;
    private String gender;
    private String email;
    private String phone;
    private Role role;
    private String username;
    private String password;
}
