package com.bpsc.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bpsc.app.model.UserMaster;
import com.bpsc.app.model.Users;
import com.bpsc.app.repository.OtpRepo;
import com.bpsc.app.repository.UserMasterRepo;
import com.bpsc.app.repository.UsersRepo;
import com.bpsc.app.service.UserMasterService;
import com.bpsc.app.util.FileUpload;

@Service
public class UserMasterServiceImpl implements UserMasterService {

	@Autowired
	private UserMasterRepo userMasterRepo;
	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private OtpRepo otpRepo;
	@Autowired
    private FileUpload fileService;

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
	
	@Override
	public String saveCandidateDocument(MultipartFile pdf, String documentType, String userName) {
		String fileName = fileService.uploadFile(pdf, userName, documentType);
		try {
			UserMaster userDoc = userMasterRepo.findByUsername(userName);
			UserMaster saveDoc;
			switch (documentType) {
			case "Photo Of Candidate":
				userDoc.setProfileImage(fileName);
				saveDoc = userMasterRepo.save(userDoc);
				break;
			case "Signature Of Candidate":
				userDoc.setSignature(fileName);
				saveDoc = userMasterRepo.save(userDoc);
				break;
			case "Aadhar Card":
				userDoc.setAadharDoc(fileName);
				saveDoc = userMasterRepo.save(userDoc);
				break;
			case "Domicile Certificate":
				userDoc.setDomicileDoc(fileName);
				saveDoc = userMasterRepo.save(userDoc);
				break;
			case "Income Certificate":
				userDoc.setIncomeProfDoc(fileName);
				saveDoc = userMasterRepo.save(userDoc);
				break;
			case "Cast Certificate":
				userDoc.setCastProfDoc(fileName);
				saveDoc = userMasterRepo.save(userDoc);
				break;
			case "Birt Certificate":
				userDoc.setBirthDoc(fileName);
				saveDoc = userMasterRepo.save(userDoc);
				break;
			case "Other Relivant Doc":
				userDoc.setOtherDoc(fileName);
				saveDoc = userMasterRepo.save(userDoc);
				break;

			default:
				throw new IllegalArgumentException("Invalid document type: " + documentType);
			}
			 if(saveDoc != null) {
            	 return fileName;
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("Unexpected error while saving user document.");
		}
		return null;
	}

}
