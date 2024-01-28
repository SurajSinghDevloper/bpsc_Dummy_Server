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
	public String saveAppliedForVacany(AppliedForVacancy afv) {
		AppliedForVacancy isAlredayExits = afvr.findByAdvNo(afv.getAdvertismentNumber());
		if(isAlredayExits ==null) {
			AppliedForVacancy newAfv = afvr.save(afv);
			if(newAfv !=null) {
				return "SAVE";
			}else {
				return "WENT_WRONG";
			}
		}
			return "EXISTS";
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
