package com.bpsc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bpsc.app.model.Qualification;

public interface QualificationRepository extends JpaRepository<Qualification, Long> {
    // Custom queries if needed
}
