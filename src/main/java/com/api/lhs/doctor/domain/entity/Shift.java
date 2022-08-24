package com.api.lhs.doctor.domain.entity;

import com.api.lhs.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "shift", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Shift extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @Temporal(TemporalType.TIME)
    private Date startShift;

    @Temporal(TemporalType.TIME)
    private Date endShift;

    @NotNull
    private Integer gapMinutes;
}
