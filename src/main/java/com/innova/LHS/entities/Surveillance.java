package com.innova.LHS.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "surveillance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Surveillance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true,nullable = false)
    private Long id;
    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kidney_test_id")
    private KidneyTest kidneyTest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "symptom_id")
    private Symptom symptom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nutrition_id")
    private Nutrition nutrition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weight_id")
    private Weight weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blood_test_id")
    private BloodTest bloodTest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "urine_test_id")
    private UrineTest urineTest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medic_id")
    private Medic medic;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "surveillance")
    private List<ElectronicMedicalRecord> electronicMedicalRecords;

}
