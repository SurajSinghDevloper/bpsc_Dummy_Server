package  com.bpsc.app.service;


import java.util.List;
import  com.bpsc.app.model.Users;


public interface UsersService {
	public Users saveUserRegistration(Users model);
	public List<Users> getAllclgRegistration();
	public boolean resetPassword(String email, String password);
	public Users getUserByEmail(String email);
}
