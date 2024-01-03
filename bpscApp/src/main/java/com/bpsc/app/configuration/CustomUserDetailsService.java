package  com.bpsc.app.configuration;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import  com.bpsc.app.model.Users;
import  com.bpsc.app.repository.*;


@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private  UsersRepo newCollegeRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	Users user = newCollegeRepo.findByUserEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new org.springframework.security.core.userdetails.User(
            user.getEmailID(),
            user.getPassword(),
            new ArrayList<>()
        );
    }
}
