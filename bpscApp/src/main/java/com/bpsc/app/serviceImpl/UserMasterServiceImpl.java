package com.bpsc.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpsc.app.model.UserMaster;
import com.bpsc.app.model.Users;
import com.bpsc.app.repository.UserMasterRepo;
import com.bpsc.app.repository.UsersRepo;
import com.bpsc.app.service.UserMasterService;

@Service
public class UserMasterServiceImpl implements UserMasterService {

	@Autowired
	UserMasterRepo userMasterRepo;
	@Autowired
	UsersRepo usersRepo;

	public UserMaster savePersonalInfo(UserMaster user) {
		UserMaster existingUserDetails = userMasterRepo.findByEmail(user.getEmail());
		if (existingUserDetails == null) {
			UserMaster newUser = userMasterRepo.save(user);
			if (newUser != null) {
				return newUser;
			}
		} else if (existingUserDetails != null) {
			existingUserDetails.setFirstname(user.getFirstname());
			existingUserDetails.setMiddlename(user.getMiddlename());
			existingUserDetails.setLastname(user.getLastname());
			existingUserDetails.setFname(user.getFname());
			existingUserDetails.setMname(user.getMname());
			existingUserDetails.setGender(user.getGender());
			existingUserDetails.setNationality(user.getNationality());
			existingUserDetails.setMaritialStatus(user.getMaritialStatus());
			existingUserDetails.setMobile(user.getMobile());
			existingUserDetails.setAadharNo(user.getAadharNo());
			existingUserDetails.setState(user.getState());
			existingUserDetails.setDistrict(user.getDistrict());
			existingUserDetails.setPincode(user.getPincode());
			existingUserDetails.setCityOrVillage(user.getCityOrVillage());
			existingUserDetails.setAddress(user.getAddress());
			existingUserDetails.setReligion(user.getReligion());
			existingUserDetails.setDomicile(user.getDomicile());
			existingUserDetails.setDisablity(user.getDisablity());
			existingUserDetails.setDisablityType(user.getDisablityType());
			existingUserDetails.setDisablityRemark(user.getDisablityRemark());
			existingUserDetails.setIdentification(user.getIdentification());
			existingUserDetails.setpLanguage(user.getpLanguage());
			existingUserDetails.setLocationType(user.getLocationType());
			existingUserDetails.setCategory(user.getCategory());
			UserMaster updateUser = userMasterRepo.save(existingUserDetails);
			if (updateUser != null) {
				Users usr = usersRepo.findByUserEmail(user.getEmail());
				usr.setFirstName(user.getFirstname());
				usr.setMiddlename(user.getMiddlename());
				usr.setLastname(user.getLastname());
				usr.setMobileNo(user.getMobile());
				usr.setFname(user.getFname());
				usr.setMname(user.getMname());
				usr.setIdentification(user.getIdentification());
				Users updateUsr = usersRepo.save(usr);
				if (updateUsr != null) {
					return updateUser;
				}
				return null;
			}
		}
		return null;
	}
}
