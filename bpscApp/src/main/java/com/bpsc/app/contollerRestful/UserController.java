package com.bpsc.app.contollerRestful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bpsc.app.model.UserMaster;
import com.bpsc.app.service.UserMasterService;
import com.bpsc.app.service.UsersService;
import com.bpsc.app.util.Base64Decoder;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	UsersService userService;
	@Autowired
	UserMasterService userMasterService;
	@Autowired
	Base64Decoder decoder;
	
	@PostMapping("/new-user/info/{email}")
	public ResponseEntity<?> savePersonalInfo(@ModelAttribute UserMaster user ,@PathVariable("email")String email){
		UserMaster newUser = userMasterService.savePersonalInfo(user,email);
		if(newUser != null) {
			return ResponseEntity.ok("Personal Info Saved Successfully");
		}else {
			 return ResponseEntity.status(409).body("Something Went wrong. User data could not be saved.");
		}
	}
	
	@GetMapping("info/{email}")
	public ResponseEntity<?> getPersonalInfo(@PathVariable String email){

		UserMaster foundUser = userMasterService.findUserByEmail(email);
		if(foundUser != null) {
			return ResponseEntity.ok(foundUser);
		}else {
			 return ResponseEntity.status(409).body("Data Not Found");
		}
	}
	
	@PostMapping("/save-doc")
    public ResponseEntity<String> saveUserDocument(
            @RequestParam("pdf") MultipartFile pdf,
            @RequestParam("documentType") String documentType,
            @RequestParam("username") String username) {
        try {
            String success = userMasterService.saveCandidateDocument(pdf, documentType, username);

            if ("NULL".equals(success) || "WENT_WRONG".equals(success)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save qualification document.");
            }

            return ResponseEntity.ok(success);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error.");
        }
    }
	
	@PostMapping("/remove-file")
    public ResponseEntity<String> deleteQualificationDocument(
            @RequestParam("docId") Long docId,
            @RequestParam("documentType") String documentType,
            @RequestParam("filename") String filename) {
        try {
            String success = userMasterService.delteCandidateDocument(docId, filename, documentType);

            if ("NULL".equals(success) || "WENT_WRONG".equals(success)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to Delete qualification document.");
            }

            return ResponseEntity.ok("Qualification document Delete successfully.");
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error.");
        }
    }
}
