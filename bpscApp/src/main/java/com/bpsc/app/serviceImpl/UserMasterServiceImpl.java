package com.bpsc.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bpsc.app.model.UserMaster;
import com.bpsc.app.model.Users;
import com.bpsc.app.repository.OtpRepo;
import com.bpsc.app.repository.UserMasterRepo;
import com.bpsc.app.repository.UsersRepo;
import com.bpsc.app.service.UserMasterService;

@Service
public class UserMasterServiceImpl implements UserMasterService {

	@Autowired
	UserMasterRepo userMasterRepo;
	@Autowired
	UsersRepo usersRepo;
	@Autowired
	OtpRepo otpRepo;

	@Override
	public UserMaster savePersonalInfo(UserMaster user, String email) {
		System.out.println(user.getEmail());
		UserMaster existingUserDetails = userMasterRepo.findByEmail(email);

		if (existingUserDetails != null) {
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
			existingUserDetails.setPermanentAddress(user.getPermanentAddress());
			UserMaster updateUser = userMasterRepo.save(existingUserDetails);

			if (updateUser != null) {
				Users usrs = usersRepo.findByUserEmail(updateUser.getEmail());
				usrs.setFirstName(user.getFirstname());
				usrs.setMiddlename(user.getMiddlename());
				usrs.setLastname(user.getLastname());
				usrs.setFname(user.getFname());
				usrs.setMname(user.getMname());
				usrs.setIdentification(user.getIdentification());

				Users updateUsr = usersRepo.save(usrs);

				if (updateUsr != null) {
					return updateUser;
				}
				return null;
			}
		} else {
			return null;
		}

		return null;
	}

	@Override
	public UserMaster findUserByEmail(String email) {
		UserMaster foundUser = userMasterRepo.findByEmail(email);
		if (foundUser != null) {
			return foundUser;
		}
		return null;
	}

}
