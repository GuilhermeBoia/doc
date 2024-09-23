package com.medway.doc.model;

import com.medway.doc.model.enums.UnidadesEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String email;

    @Column(nullable = false)
    private UnidadesEnum unidadeDeEstudo;

}
