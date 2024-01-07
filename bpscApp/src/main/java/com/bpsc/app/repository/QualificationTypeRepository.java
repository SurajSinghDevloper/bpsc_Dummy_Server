package com.bpsc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bpsc.app.model.QualificationType;

public interface QualificationTypeRepository extends JpaRepository<QualificationType, Long> {
    // Custom queries if needed
}
