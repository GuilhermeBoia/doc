package com.medway.doc.model;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import com.medway.doc.model.enums.UnidadesEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Reuniao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "re_aluno", nullable = false)
    private Aluno aluno;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataReuniao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UnidadesEnum unidadeDeAtendimento;

    @Column(nullable = true)
    private String observacoes;
}