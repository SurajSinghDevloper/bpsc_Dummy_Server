package com.bpsc.app.contollerRestful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bpsc.app.model.QualificationDoc;
import com.bpsc.app.service.QualificationDocService;

@RestController
@RequestMapping("/api/qualification-types")
@CrossOrigin(origins = "http://localhost:3000")
public class QualificationDocController {

    @Autowired
    private QualificationDocService qualificationDocService;

    @PostMapping("/save")
    public ResponseEntity<String> saveQualificationDocument(
            @RequestParam("pdf") MultipartFile pdf,
            @RequestParam("documentType") String documentType,
            @RequestParam("username") String username) {
        try {
            String success = qualificationDocService.saveQualificationDocument(pdf, documentType, username);

            if ("NULL".equals(success) || "WENT_WRONG".equals(success)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save qualification document.");
            }

            return ResponseEntity.ok("Qualification document saved successfully.");
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error.");
        }
    }
    
    @GetMapping("/find-doc")
    public ResponseEntity<?> findDocAsPerUserName(@RequestParam("userName") String userName){
    	QualificationDoc foundDoc = qualificationDocService.findByUserName(userName);
    	if(foundDoc != null) {
    		return ResponseEntity.ok(foundDoc);
    	}
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to Find qualification document.");
    }
    
}
