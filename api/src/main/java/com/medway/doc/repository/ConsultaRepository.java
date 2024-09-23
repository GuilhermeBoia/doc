package com.medway.doc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medway.doc.model.Aluno;
import com.medway.doc.model.Consulta;
import com.medway.doc.model.Terapeuta;

import java.util.List;
import java.time.LocalDate;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    
    List<Consulta> findByAluno(Aluno aluno);
    List<Consulta> findByTerapeuta(Terapeuta terapeuta);
    List<Consulta> findByTerapeutaAndDataDaConsulta(Terapeuta terapeuta, LocalDate data);

}
