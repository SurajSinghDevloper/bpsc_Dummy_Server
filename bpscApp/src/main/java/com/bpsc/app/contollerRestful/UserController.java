package com.bpsc.app.contollerRestful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bpsc.app.model.UserMaster;
import com.bpsc.app.service.UserMasterService;
import com.bpsc.app.service.UsersService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	UsersService userService;
	@Autowired
	UserMasterService userMasterService;
	
	@PostMapping("/new-user/info")
	public ResponseEntity<?> savePersonalInfo(@ModelAttribute UserMaster user){
		UserMaster newUser = userMasterService.savePersonalInfo(user);
		if(newUser != null) {
			return ResponseEntity.ok("Personal Info Saved Successfully");
		}else {
			 return ResponseEntity.status(409).body("Something Went wrong. User data could not be saved.");
		}
	}
}
