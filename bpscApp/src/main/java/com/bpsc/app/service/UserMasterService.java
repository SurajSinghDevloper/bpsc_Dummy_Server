package com.bpsc.app.service;

import org.springframework.web.multipart.MultipartFile;

import com.bpsc.app.model.UserMaster;

public interface UserMasterService {
	public UserMaster savePersonalInfo(UserMaster user,String email);
	public UserMaster findUserByEmail(String email);
	public String saveCandidateDocument(MultipartFile pdf, String documentType, String userName);
}
