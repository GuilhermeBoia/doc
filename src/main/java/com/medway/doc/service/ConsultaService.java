package com.medway.doc.service;

import com.medway.doc.model.Consulta;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

public interface ConsultaService {
    
    Consulta criarConsulta(Consulta consulta);
    Optional<Consulta> buscarConsultaPorId(Long id);
    List<Consulta> buscarConsultaPorAlunoRE(String re_aluno);
    List<Consulta> buscarConsultaPorTerapeutaId(Long id_terapeuta);
    List<Consulta> buscarConsultasDoDiaTerapeuta(Long id_terapeuta, LocalDate data);
    void cancelarConsulta(Long id);

}
