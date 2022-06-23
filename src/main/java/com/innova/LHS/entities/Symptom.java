package com.innova.LHS.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "symptom")
public class Symptom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true,nullable = false)
    private Long id;
    @Column(name = "appetite")
    private String appetite;
    @Column(name = "pains")
    private String pains;
    @Column(name = "weight_variation")
    private String weightVariation;
    @Column(name = "other")
    private String other;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "symptom")
    private List<Surveillance> surveillances;

}
