package com.bpsc.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bpsc.app.model.AppliedForVacancy;


public interface AppliedForVacancyRepo extends JpaRepository<AppliedForVacancy, Long>{
	@Query("SELECT v FROM AppliedForVacancy v WHERE v.userName = :userName")
	public List<AppliedForVacancy> findByUsername(@Param("userName") String userName);
	
	@Query("SELECT v FROM AppliedForVacancy v WHERE v.advertismentNumber = :advertismentNumber")
	public AppliedForVacancy findByAdvNo(@Param("advertismentNumber")String advertismentNumber);
	
	
}
