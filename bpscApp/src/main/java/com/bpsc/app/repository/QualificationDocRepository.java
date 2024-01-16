package com.bpsc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bpsc.app.model.QualificationDoc;

public interface QualificationDocRepository extends JpaRepository<QualificationDoc, Long> {
    // Custom queries if needed
}
