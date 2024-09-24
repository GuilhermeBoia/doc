package com.medway.doc.service;

import com.medway.doc.model.AssessoriaAcademica;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

public interface AssessoriaService {
    AssessoriaAcademica criarAssessoria(AssessoriaAcademica assessoria);
    Optional<AssessoriaAcademica> buscarAssessoriaPorId(Long id);
    List<AssessoriaAcademica> buscarAssessoriaPorAlunoRE(String re_aluno);
    List<AssessoriaAcademica> buscarAssessoriaPorAssessorId(Long id_assessor);
    List<AssessoriaAcademica> buscarAssessoriasDoDiaAssessor(Long id_assessor, LocalDate data);
    void cancelarAssessoria(Long id);
}