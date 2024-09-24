package com.medway.doc.controller;

import java.util.List;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.medway.doc.model.AssessoriaAcademica;
import com.medway.doc.service.AssessoriaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/assessorias")
@CrossOrigin
public class AssessoriaController {
    @Autowired
    private AssessoriaService assessoriaService;

    @PostMapping("/registrar")
    public ResponseEntity<AssessoriaAcademica> criarAssessoria(@Valid @RequestBody AssessoriaAcademica assessoria) {
        return new ResponseEntity<>(assessoriaService.criarAssessoria(assessoria), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssessoriaAcademica> buscarAssessoriaPorId(@PathVariable Long id) {
        return assessoriaService.buscarAssessoriaPorId(id)
            .map(assessoria -> new ResponseEntity<>(assessoria, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/aluno/{re_aluno}")
    public ResponseEntity<List<AssessoriaAcademica>> buscarAssessoriasPorAlunoRE(@PathVariable String re_aluno) {
        List<AssessoriaAcademica> assessorias = assessoriaService.buscarAssessoriaPorAlunoRE(re_aluno);
        if (assessorias != null && !assessorias.isEmpty()) {
            return new ResponseEntity<>(assessorias, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/assessor/{id_assessor}")
    public ResponseEntity<List<AssessoriaAcademica>> buscarAssessoriasPorAssessorId(@PathVariable Long id_assessor) {
        List<AssessoriaAcademica> assessorias = assessoriaService.buscarAssessoriaPorAssessorId(id_assessor);
        if (assessorias != null && !assessorias.isEmpty()) {
            return new ResponseEntity<>(assessorias, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/assessor/{id_assessor}/data")
    public ResponseEntity<List<AssessoriaAcademica>> buscarAssessoriasDoDiaAssessor(@PathVariable Long id_assessor) {
        List<AssessoriaAcademica> assessorias = assessoriaService.buscarAssessoriasDoDiaAssessor(id_assessor, LocalDate.now());
        if (assessorias != null && !assessorias.isEmpty()) {
            return new ResponseEntity<>(assessorias, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarAssessoria(@PathVariable Long id) {
        assessoriaService.cancelarAssessoria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
