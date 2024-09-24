package com.medway.doc.model;

import com.medway.doc.model.enums.UnidadesEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "alunos")
public class Aluno {

    @Column(unique = true)
    @Id
    private String registroEstudantil;
    
    @Column(nullable = false)
    private String primeiroNome;

    @Column(nullable = false)
    private String ultimoNome;

    @Column(nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @Column(nullable = false)
    private UnidadesEnum unidadeDeEstudo;

    @Column(nullable = false)
    @Pattern(regexp = "^[1-9][A-E]$")
    private String turma;

    @ManyToOne
    @JoinColumn(name = "id_assessor", nullable = false)
    private Assessor assessor;

}
