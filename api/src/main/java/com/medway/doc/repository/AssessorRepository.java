package com.medway.doc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.medway.doc.model.Assessor;

@Repository
public interface AssessorRepository extends JpaRepository<Assessor, Long> {

    boolean existsByEmail(String userEmail);
    
}
