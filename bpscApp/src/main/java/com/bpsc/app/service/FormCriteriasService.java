package com.bpsc.app.service;

import com.bpsc.app.model.FormCriterias;
import com.bpsc.app.model.Vacany;

public interface FormCriteriasService {
	public FormCriterias saveFormCriteria(FormCriterias fc, String advNo);
	public FormCriterias getByUserName(String userName);
	public String createCriteria (Vacany vac);
}
