package com.bpsc.app.service;

import com.bpsc.app.model.FormCriterias;
import com.bpsc.app.model.Vacany;

public interface FormCriteriasService {
	public FormCriterias saveFormCriteria(FormCriterias fc, String advNo);
	public FormCriterias getByAdvNo(String userName);
	public String createCriteria (Vacany vac);
}
