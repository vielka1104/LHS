package com.innova.LHS.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "weight")
public class Weight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true,nullable = false)
    private Long id;
    @Column(name = "weight")
    private Long weight;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "weight")
    private List<Surveillance> surveillances;
}
