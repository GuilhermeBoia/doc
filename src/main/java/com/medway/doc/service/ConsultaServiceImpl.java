package com.medway.doc.service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.medway.doc.model.Aluno;
import com.medway.doc.model.Consulta;
import com.medway.doc.model.Terapeuta;
import com.medway.doc.repository.AlunoRepository;
import com.medway.doc.repository.ConsultaRepository;
import com.medway.doc.repository.TerapeutaRepository;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TerapeutaRepository terapeutaRepository;

    @Override
    public Consulta criarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Override
    public Optional<Consulta> buscarConsultaPorId(Long id) {
        return consultaRepository.findById(id);
    }

    @Override
    public List<Consulta> buscarConsultaPorAlunoRE(String re_aluno) {
        Optional<Aluno> aluno = alunoRepository.findById(re_aluno);
        if (aluno.isPresent()) {
            return consultaRepository.filterConsultasByAluno(aluno.get());
        }
        return null;
    }

    @Override
    public List<Consulta> buscarConsultaPorTerapeutaId(Long id_terapeuta) {
        Optional<Terapeuta> terapeuta = terapeutaRepository.findById(id_terapeuta);
        if (terapeuta.isPresent()) {
            return consultaRepository.filterConsultasByTerapeuta(terapeuta.get());
        }
        return null;
    }

    @Override
    public List<Consulta> buscarConsultasDoDiaTerapeuta(Long id_terapeuta, LocalDate data) {
        Optional<Terapeuta> terapeuta = terapeutaRepository.findById(id_terapeuta);
        if (terapeuta.isPresent() && data.equals(LocalDate.now())) {
            return consultaRepository.filterConsultasByTerapeutaAndDate(terapeuta.get(), data);
        }
        return null;
    }

    @Override
    public void cancelarConsulta(Long id) {
        consultaRepository.deleteById(id);
    }


}
