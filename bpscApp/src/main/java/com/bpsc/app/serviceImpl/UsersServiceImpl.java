package  com.bpsc.app.serviceImpl;


import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpsc.app.model.Otp;
import  com.bpsc.app.model.Users;
import com.bpsc.app.repository.OtpRepo;
import  com.bpsc.app.repository.UsersRepo;
import  com.bpsc.app.service.UsersService;
import  com.bpsc.app.service.OtpService;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersRepo userRepo;
	@Autowired
	private OtpRepo otpRepo;
	@Autowired
	private OtpService otpService;

    public static String generateUniqueUsername(String firstName) {
        String uniqueID = UUID.randomUUID().toString().replace("-", "");
        String usernamePrefix = firstName+"_";
        // Taking the first 10 characters from the UUID
        String uniquePortion = uniqueID.substring(0, 6); 
        return usernamePrefix + uniquePortion;
    }

	@Override
	public Users saveUserRegistration(Users model) {
		// TODO Auto-generated method stub
		String userName = generateUniqueUsername(model.getFirstName());
		model.setUserName(userName);
		List<Otp> otps = otpRepo.getOtpByEmailOrderByDesc(model.getEmailID());
	    
	    if (otps != null && !otps.isEmpty()) {
	        Otp otpEntity = otps.get(0);
	        if(otpEntity != null) {
	        	String flag =otpEntity.getOtpFlg();
	        	if(flag.equals("1")) {
	        		model.setIsEmailVarified("true");
	        		return userRepo.save(model);
	        	}
	        }
	    }
		return null;
	}

	@Override
	public List<Users> getAllclgRegistration() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public Users getUserByEmail(String email) {
		Users user = userRepo.findByUserEmail(email);
		if(user !=null) {
			return user;
		}
		return null;
	}
	
	@Override
	public boolean resetPassword(String email, String password) {
		Users college = userRepo.findByUserEmail(email);
		if(college !=null ) {
			college.setPassword(password);
			Users success = userRepo.save(college);
			if(success != null) {
				otpService.otpflagChange(email);
				return true;
			}
		}
		
		return false;
	}

}
