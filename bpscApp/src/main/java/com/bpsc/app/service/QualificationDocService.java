package com.bpsc.app.service;

import org.springframework.web.multipart.MultipartFile;

import com.bpsc.app.model.QualificationDoc;

public interface QualificationDocService {
	 public String saveQualificationDocument(MultipartFile pdf, String documentType, String userName);
	
	public String delteQualificationDocument(long qualificationId,  String filename,String documentType);
	
	public QualificationDoc findByUserName (String username);
}
