package com.innova.LHS.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "urine_tests")
public class UrineTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true,nullable = false)
    private Long id;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "urineTest")
    private List<Surveillance> surveillances;
}
