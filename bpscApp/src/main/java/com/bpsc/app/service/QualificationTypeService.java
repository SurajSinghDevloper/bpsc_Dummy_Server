package com.bpsc.app.service;

import java.util.List;

import com.bpsc.app.model.QualificationType;

public interface QualificationTypeService {
	public List<QualificationType> getAllQualificationTypes();
	
	public QualificationType getQualificationTypeById(long qualificationId);
	
	public QualificationType saveQualificationType(QualificationType qualificationType);
	
	 public void deleteQualificationType(long qualificationId);
}
