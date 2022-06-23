package com.innova.LHS.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "treatments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true,nullable = false)
    private Long id;
    @Column(name = "type_treatment" )
    private String typeTreatment;
    @Column(name = "date" )
    private LocalDate date;
    @Column(name = "description")
    private String description;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "treatment")
    private List<ElectronicMedicalRecord> electronicMedicalRecords;

}
