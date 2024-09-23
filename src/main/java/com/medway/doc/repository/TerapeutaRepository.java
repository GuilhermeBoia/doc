package com.medway.doc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medway.doc.model.Terapeuta;

public interface TerapeutaRepository extends JpaRepository<Terapeuta, Long> {
    
}
