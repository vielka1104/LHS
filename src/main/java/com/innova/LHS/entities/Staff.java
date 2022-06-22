package com.innova.LHS.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "staff")
@Data
public class Staff {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id", unique = true,nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "cellphone" )
    private String cellphone;
    @Column(name = "address")
    private String address;
}
