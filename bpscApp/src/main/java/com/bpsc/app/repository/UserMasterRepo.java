package com.bpsc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bpsc.app.model.UserMaster;

public interface UserMasterRepo extends JpaRepository<UserMaster, Long>{
	@Query("SELECT u FROM UserMaster u WHERE u.email = :email")
	public UserMaster findByEmail(@Param("email") String email);
}
