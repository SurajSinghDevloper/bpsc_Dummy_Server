package com.bpsc.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpsc.app.model.AppliedForVacancy;
import com.bpsc.app.repository.AppliedForVacancyRepo;
import com.bpsc.app.service.AppliedForVacancyService;

@Service
public class AppliedForVacancyServiceImpl implements AppliedForVacancyService{

	@Autowired
	AppliedForVacancyRepo afvr;
	
	@Override
	public AppliedForVacancy saveAppliedForVacany(AppliedForVacancy afv) {
		AppliedForVacancy newAfv = afvr.save(afv);
		if(newAfv !=null) {
			return newAfv;
		}
		return null;
	}
	
	@Override
	public List<AppliedForVacancy> getAllApplied(String username){
		List<AppliedForVacancy> listOfVacancy = afvr.findByUsername(username);
		if(listOfVacancy !=null) {
			return listOfVacancy;
		}
		return null;
	}
}
