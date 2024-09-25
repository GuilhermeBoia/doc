package com.medway.doc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medway.doc.repository.AssessorRepository;
import com.medway.doc.repository.TerapeutaRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AssessorRepository assessorRepository;

    @Autowired
    private TerapeutaRepository terapeutaRepository;
    public String getUserType(String userEmail) {
        if (userEmail == null || userEmail.isEmpty()) {
            return "unknown";
        }

        if (assessorRepository.existsByEmail(userEmail)) {
            return "assessor";
        } else if (terapeutaRepository.existsByEmail(userEmail)) {
            return "terapeuta";
        }
        
        return "unknown";
    }
}