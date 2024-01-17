package com.bpsc.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bpsc.app.model.QualificationType;
import com.bpsc.app.model.UserMaster;

public interface QualificationTypeRepository extends JpaRepository<QualificationType, Long> {
    // Custom queries if needed

	List<QualificationType> findByUserMaster(UserMaster userMaster);

}
