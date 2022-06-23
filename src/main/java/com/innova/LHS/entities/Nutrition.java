package com.innova.LHS.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nutrition")
public class Nutrition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true,nullable = false)
    private Long id;

    @Column(name = "plan")
    private String plan;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "nutrition")
    private List<Surveillance> surveillances;
}
