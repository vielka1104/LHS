package com.innova.LHS.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kidney_tests")
public class KidneyTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true,nullable = false)
    private Long id;
    @Column(name = "kidney_stage")
    private String kidneyStage;
    @Column(name = "description")
    private String description;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "kidney_test")
    private List<Surveillance> surveillances;
}
