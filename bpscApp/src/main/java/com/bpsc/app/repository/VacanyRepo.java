package com.bpsc.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bpsc.app.model.Vacany;

public interface VacanyRepo extends JpaRepository<Vacany, Long>{
	
	@Query("SELECT u FROM Vacany u WHERE u.userName = :userName")
	public List<Vacany> findByUsername(@Param("userName") String userName);
}
