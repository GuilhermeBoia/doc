package com.medway.doc.model;


import com.medway.doc.model.enums.SituacaoMentalEnum;
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
@Table(name = "consultas_terapeuticas")
public class ConsultaTerapeutica extends Reuniao {

    @ManyToOne
    @JoinColumn(name = "id_terapeuta", nullable = false)
    private Terapeuta terapeuta;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SituacaoMentalEnum situacaoMental;

    @Column(nullable = false)
    private String queixaPrincipal;

    @Column(nullable = true)
    private String observacoes;
    
}
