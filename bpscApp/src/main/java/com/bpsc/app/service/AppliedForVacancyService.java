package com.bpsc.app.service;

import java.util.List;

import com.bpsc.app.model.AppliedForVacancy;

public interface AppliedForVacancyService {
	public String saveAppliedForVacany(AppliedForVacancy afv);
	
	public List<AppliedForVacancy> getAllApplied(String username);
}
