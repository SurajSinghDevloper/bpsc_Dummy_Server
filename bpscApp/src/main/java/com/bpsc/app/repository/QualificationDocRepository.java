package com.bpsc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bpsc.app.model.QualificationDoc;
import com.bpsc.app.model.UserMaster;

public interface QualificationDocRepository extends JpaRepository<QualificationDoc, Long> {
    // Custom queries if needed
	@Query("SELECT u FROM QualificationDoc u WHERE u.userName = :username")
	public QualificationDoc findByUserName(@Param("username") String username);
}
