package com.medway.doc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medway.doc.model.Aluno;
import com.medway.doc.model.ConsultaTerapeutica;
import com.medway.doc.model.Terapeuta;

import java.util.List;
import java.time.LocalDate;

public interface ConsultaRepository extends JpaRepository<ConsultaTerapeutica, Long> {
    
    List<ConsultaTerapeutica> findByAluno(Aluno aluno);
    List<ConsultaTerapeutica> findByTerapeuta(Terapeuta terapeuta);
    List<ConsultaTerapeutica> findByTerapeutaAndDataReuniao(Terapeuta terapeuta, LocalDate data);

}
