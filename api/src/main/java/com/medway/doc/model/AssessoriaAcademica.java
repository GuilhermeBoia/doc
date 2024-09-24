package com.medway.doc.model;

import com.medway.doc.model.enums.DesempenhoAcademicoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assessorias_academicas")
public class AssessoriaAcademica extends Reuniao {

    @ManyToOne
    @JoinColumn(name = "id_assessor", nullable = false)
    private Assessor assessor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DesempenhoAcademicoEnum desempenhoAcademico;

}