package com.medway.doc.service;

import com.medway.doc.model.ConsultaTerapeutica;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

public interface ConsultaService {
    
    ConsultaTerapeutica criarConsulta(ConsultaTerapeutica consulta);
    Optional<ConsultaTerapeutica> buscarConsultaPorId(Long id);
    List<ConsultaTerapeutica> buscarConsultaPorAlunoRE(String re_aluno);
    List<ConsultaTerapeutica> buscarConsultaPorTerapeutaId(Long id_terapeuta);
    List<ConsultaTerapeutica> buscarConsultasDoDiaTerapeuta(Long id_terapeuta, LocalDate data);
    void cancelarConsulta(Long id);

}
