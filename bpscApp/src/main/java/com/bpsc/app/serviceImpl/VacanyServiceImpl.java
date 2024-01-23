package com.bpsc.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpsc.app.model.Vacany;
import com.bpsc.app.repository.VacanyRepo;
import com.bpsc.app.service.VacanyService;

@Service
public class VacanyServiceImpl implements VacanyService{
	
	@Autowired
	VacanyRepo vRepo;
	
	@Override
	public Vacany saveVacancy(Vacany vac) {
		Vacany saveVacancy = vRepo.save(vac);
		if(saveVacancy != null) {
			return saveVacancy;
		}
		return null;
	}
	
	@Override
	public List<Vacany> findVacancyByUserName(String username) {
		List<Vacany> foundVacancy = vRepo.findByUsername(username);
		if(foundVacancy !=null) {
			return foundVacancy;
		}
		return null;
	}
	
	@Override
	public List<Vacany> findAll() {
		List<Vacany> foundVacancy = vRepo.findAll();
		if(foundVacancy !=null) {
			return foundVacancy;
		}
		return null;
	}
}
