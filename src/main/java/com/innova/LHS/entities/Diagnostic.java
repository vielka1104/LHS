package com.innova.LHS.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "diagnostics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diagnostic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true,nullable = false)
    private Long id;
    @Column(name = "type_diagnostic")
    private String typeDiagnostic;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    private LocalDate date;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "diagnostic")
    private List<ElectronicMedicalRecord> electronicMedicalRecords;

}
