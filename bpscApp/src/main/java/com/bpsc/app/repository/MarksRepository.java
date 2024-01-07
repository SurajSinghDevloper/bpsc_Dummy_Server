package com.bpsc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bpsc.app.model.Marks;

public interface MarksRepository extends JpaRepository<Marks, Long> {
    // Custom queries if needed
}
