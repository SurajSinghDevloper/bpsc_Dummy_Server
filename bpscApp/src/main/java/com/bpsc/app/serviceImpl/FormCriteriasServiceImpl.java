package com.bpsc.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpsc.app.model.FormCriterias;
import com.bpsc.app.model.Vacany;
import com.bpsc.app.repository.FormCriteriasRepo;
import com.bpsc.app.repository.VacanyRepo;
import com.bpsc.app.service.FormCriteriasService;


@Service
public class FormCriteriasServiceImpl implements FormCriteriasService{
	
	@Autowired
	FormCriteriasRepo fcr;
	@Autowired
	VacanyRepo vcr;

	@Override
	public FormCriterias saveFormCriteria(FormCriterias fc, String advNo) {
	    if (advNo != null) {
	        FormCriterias existingCriteria = fcr.findByAdvNo(advNo);
	        if (existingCriteria != null) {
	            existingCriteria.setIsCitizenOfIndia(fc.getIsCitizenOfIndia());
	            existingCriteria.setIsOriginOfBihar(fc.getIsOriginOfBihar());
	            existingCriteria.setIsRegServiceInBiharGov(fc.getIsRegServiceInBiharGov());
	            existingCriteria.setIsSonOfFreedomFighter(fc.getIsSonOfFreedomFighter());
	            existingCriteria.setIsEXServiceManOfArmy(fc.getIsEXServiceManOfArmy());
	            existingCriteria.setHasRequiredQualification(fc.getHasRequiredQualification());
	            existingCriteria.setAggreWithDeclaration(fc.getAggreWithDeclaration());
	            existingCriteria.setIsDone("D");
	            
	            return fcr.save(existingCriteria);
	        }else if(existingCriteria ==null){
	        	Vacany existingVacancy = vcr.findByAdvertismentNumber(advNo);
	        	fc.setVacancy(existingVacancy);
	        	return fcr.save(fc);
	        }
	    }

	   
	    return null;
	}

	
	@Override
	public FormCriterias getByAdvNo( String userName) {
		FormCriterias existingCriteria = fcr.findByUsername(userName);
	
		if(existingCriteria !=null) {
			return existingCriteria;
		}
		return null;
	}
	
	@Override
	public String createCriteria (Vacany vac) {
		FormCriterias existingCriteria = fcr.findByAdvNo(vac.getAdvertismentNumber());
		if(existingCriteria ==null) {
			FormCriterias fc = new FormCriterias();
			fc.setVacancy(vac);
			fc.setUserName(vac.getUserName());
			fcr.save(fc);
			return "SAVED";
		}else if(existingCriteria !=null){
			return "EXIST";
		}
		return "WENT_WRONG";
	}
}
