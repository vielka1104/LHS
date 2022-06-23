package com.innova.LHS.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "blood_tests")
@Data
public class BloodTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true,nullable = false)
    private Long id;
    @Column(name = "creation_date")
    private String creationDate;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "bloodTest")
    private List<Surveillance> surveillances;
}
