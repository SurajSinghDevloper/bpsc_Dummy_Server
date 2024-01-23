package com.bpsc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bpsc.app.model.FormCriterias;
import com.bpsc.app.model.UserMaster;


public interface FormCriteriasRepo extends JpaRepository<FormCriterias, Long>{
	
    @Query("SELECT u FROM FormCriterias u WHERE u.vacancy.advertismentNumber = :advertismentNumber")
    FormCriterias findByAdvNo(@Param("advertismentNumber") String advertismentNumber);
    
    @Query("SELECT f FROM FormCriterias f WHERE f.userName = :userName")
	public FormCriterias findByUsername(@Param("userName") String userName);
}
