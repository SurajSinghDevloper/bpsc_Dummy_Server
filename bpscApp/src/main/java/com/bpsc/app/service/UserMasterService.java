package com.bpsc.app.service;

import com.bpsc.app.model.UserMaster;

public interface UserMasterService {
	public UserMaster savePersonalInfo(UserMaster user,String email);
	public UserMaster findUserByEmail(String email);
}
