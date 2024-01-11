package com.bpsc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bpsc.app.model.UserMaster;

public interface UserMasterRepo extends JpaRepository<UserMaster, Long>{
	public UserMaster findByEmail(String email);
}
