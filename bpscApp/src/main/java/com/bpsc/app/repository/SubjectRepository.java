package com.bpsc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bpsc.app.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    // Custom queries if needed
}
