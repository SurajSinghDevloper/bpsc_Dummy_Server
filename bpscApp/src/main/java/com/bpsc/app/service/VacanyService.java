package com.bpsc.app.service;

import java.util.List;

import com.bpsc.app.model.Vacany;

public interface VacanyService {
	
	public Vacany saveVacancy(Vacany vac) ;
	
	public List<Vacany> findVacancyByUserName(String username);
	
	public List<Vacany> findAll();

}
