package com.bpsc.app.contollerRestful;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bpsc.app.configuration.CustomUserDetailsService;
import com.bpsc.app.configuration.JwtUtil;
import com.bpsc.app.configuration.LoginResponse;
import com.bpsc.app.model.Users;
import com.bpsc.app.service.UsersService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/auth/")
public class AuthController {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UsersService userService;

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@PostMapping("registration")
	public ResponseEntity<?> saveaccountreport(@ModelAttribute Users registration) {

		String email = registration.getEmailID();
		Users user = userService.getUserByEmail(email);
		if (user == null) {
			String hashedPassword = passwordEncoder.encode(registration.getPassword());
			registration.setPassword(hashedPassword);
			Users saveUser = userService.saveUserRegistration(registration);
			if(saveUser != null) {
				return ResponseEntity.status(201).body("User Saved Successfully");
			}
		}else {
			return ResponseEntity.status(409).body("User Already Exists");
		}

		
		return ResponseEntity.status(400).body("Error while saving data");

	}

	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody Users login) {
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(login.getEmailID(), login.getPassword()));

			// Load user details
			UserDetails userDetails = userDetailsService.loadUserByUsername(login.getEmailID());

			// Generate JWT token
			String token = jwtUtil.generateToken(login.getEmailID());

			Users user = userService.getUserByEmail(userDetails.getUsername());
			String varifiedUser = user.getIsEmailVarified();
			if (user != null && varifiedUser.equals("True")) {
				// Create a response object with token and user details
				lastLoginDetail(userDetails.getUsername());

				LoginResponse loginResponse = new LoginResponse(token, user);
				return ResponseEntity.ok(loginResponse);
			} else {
				return ResponseEntity.badRequest().body("Not A Varified User Please Verify your email");
			}

		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during login");
		}
	}

	private LocalDateTime lastLoginDetail(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("password")
	public ResponseEntity<?> resetPassword(@RequestParam String email, @RequestParam String password) {
		String hashedPassword = passwordEncoder.encode(password);
		boolean success = userService.resetPassword(email, hashedPassword);
		if (success) {
			return ResponseEntity.ok("Password reset successfully for user with email: " + email);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Password reset failed for user with email: " + email);
	}

}
