package com.innova.LHS.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "procedures")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true,nullable = false)
    private Long id;
    @Column(name = "description")
    private String description ;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "procedure")
    private List<ElectronicMedicalRecord> electronicMedicalRecords;
}
