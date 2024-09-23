package com.medway.doc.model;

import org.springframework.format.annotation.DateTimeFormat;

import com.medway.doc.model.enums.SituacaoMentalEnum;
import com.medway.doc.model.enums.UnidadesEnum;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "re_aluno", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_terapeuta", nullable = false)
    private Terapeuta terapeuta;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataDaConsulta;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UnidadesEnum unidadeDeAtendimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SituacaoMentalEnum situacaoMental;

    @Column(nullable = false)
    private String queixaPrincipal;

    @Column(nullable = true)
    private String observacoes;
    
}
