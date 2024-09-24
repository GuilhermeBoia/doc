package com.medway.doc.service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.medway.doc.model.Aluno;
import com.medway.doc.repository.AlunoRepository;
import com.medway.doc.repository.AssessorRepository;
import com.medway.doc.repository.AssessoriaRepository;
import com.medway.doc.model.Assessor;
import com.medway.doc.model.AssessoriaAcademica;

@Service
public class AssessoriaServiceImpl implements AssessoriaService{

    @Autowired
    private AssessoriaRepository assessoriaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AssessorRepository assessorRepository;

        @Override
    public AssessoriaAcademica criarAssessoria(AssessoriaAcademica assessoria) {
        return assessoriaRepository.save(assessoria);
    }

    @Override
    public Optional<AssessoriaAcademica> buscarAssessoriaPorId(Long id) {
        return assessoriaRepository.findById(id);
    }

    @Override
    public List<AssessoriaAcademica> buscarAssessoriaPorAlunoRE(String re_aluno) {
        Optional<Aluno> aluno = alunoRepository.findById(re_aluno);
        if (aluno.isPresent()) {
            return assessoriaRepository.findByAluno(aluno.get());
        }
        return null;
    }

    @Override
    public List<AssessoriaAcademica> buscarAssessoriaPorAssessorId(Long id_assessor) {
        Optional<Assessor> assessor = assessorRepository.findById(id_assessor);
        if (assessor.isPresent()) {
            return assessoriaRepository.findByAssessor(assessor.get());
        }
        return null;
    }

    @Override
    public List<AssessoriaAcademica> buscarAssessoriasDoDiaAssessor(Long id_assessor, LocalDate data) {
        Optional<Assessor> assessor = assessorRepository.findById(id_assessor);
        if (assessor.isPresent() && data.equals(LocalDate.now())) {
            return assessoriaRepository.findByAssessorAndDataReuniao(assessor.get(), data);
        }
        return null;
    }

    @Override
    public void cancelarAssessoria(Long id) {
        assessoriaRepository.deleteById(id);
    }
    
}
