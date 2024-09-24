package com.medway.doc.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import com.medway.doc.model.Aluno;
import com.medway.doc.model.Assessor;
import com.medway.doc.model.AssessoriaAcademica;

@Repository
public interface AssessoriaRepository extends JpaRepository<AssessoriaAcademica, Long> {
 
    List<AssessoriaAcademica> findByAluno(Aluno aluno);
    List<AssessoriaAcademica> findByAssessor(Assessor assessor);
    List<AssessoriaAcademica> findByAssessorAndDataReuniao(Assessor assessor, LocalDate data);

}
