package com.innova.LHS.entities;

import com.innova.LHS.enums.SexId;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true,nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "birth")
    private LocalDate birth;

    @Column
    private SexId sex;

    //TODO: historial clinico
}
