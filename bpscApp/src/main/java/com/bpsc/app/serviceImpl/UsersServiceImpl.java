package  com.bpsc.app.serviceImpl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.bpsc.app.model.Users;
import  com.bpsc.app.repository.UsersRepo;
import  com.bpsc.app.service.UsersService;
import  com.bpsc.app.service.OtpService;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersRepo userRepo;
	@Autowired
	private OtpService otpService;



	@Override
	public Users saveUserRegistration(Users model) {
		// TODO Auto-generated method stub
		return userRepo.save(model);
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
