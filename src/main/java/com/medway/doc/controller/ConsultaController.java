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
import com.medway.doc.model.Consulta;
import com.medway.doc.service.ConsultaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
@CrossOrigin
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping("/registrar")
    public ResponseEntity<Consulta> criarConsulta(@Valid @RequestBody Consulta consulta) {
        return new ResponseEntity<>(consultaService.criarConsulta(consulta), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscarConsultaPorId(@PathVariable Long id) {
        return consultaService.buscarConsultaPorId(id)
            .map(consulta -> new ResponseEntity<>(consulta, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/aluno/{re_aluno}")
    public ResponseEntity<List<Consulta>> buscarConsultasPorAlunoRE(@PathVariable String re_aluno) {
        List<Consulta> consultas = consultaService.buscarConsultaPorAlunoRE(re_aluno);
        if (consultas != null && !consultas.isEmpty()) {
            return new ResponseEntity<>(consultas, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/terapeuta/{id_terapeuta}")
    public ResponseEntity<List<Consulta>> buscarConsultasPorTerapeutaId(@PathVariable Long id_terapeuta) {
        List<Consulta> consultas = consultaService.buscarConsultaPorTerapeutaId(id_terapeuta);
        if (consultas != null && !consultas.isEmpty()) {
            return new ResponseEntity<>(consultas, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/terapeuta/{id_terapeuta}/data")
    public ResponseEntity<List<Consulta>> buscarConsultasDoDiaTerapeuta(@PathVariable Long id_terapeuta) {
        List<Consulta> consultas = consultaService.buscarConsultasDoDiaTerapeuta(id_terapeuta, LocalDate.now());
        if (consultas != null && !consultas.isEmpty()) {
            return new ResponseEntity<>(consultas, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarConsulta(@PathVariable Long id) {
        consultaService.cancelarConsulta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
