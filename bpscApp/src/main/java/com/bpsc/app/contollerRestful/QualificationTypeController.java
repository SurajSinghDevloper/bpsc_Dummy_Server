package com.bpsc.app.contollerRestful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bpsc.app.model.QualificationType;
import com.bpsc.app.repository.UserMasterRepo;
import com.bpsc.app.service.QualificationTypeService;

@RestController
@CrossOrigin
@RequestMapping("/api/qualification-types")
public class QualificationTypeController {
	
	@Autowired
    private QualificationTypeService qualificationTypeService;
	
	
	@GetMapping
    public ResponseEntity<List<QualificationType>> getAllQualificationTypes() {
        List<QualificationType> qualificationTypes = qualificationTypeService.getAllQualificationTypes();
        return new ResponseEntity<>(qualificationTypes, HttpStatus.OK);
    }

    @GetMapping("/{qualificationId}")
    public ResponseEntity<QualificationType> getQualificationTypeById(@PathVariable long qualificationId) {
        QualificationType qualificationType = qualificationTypeService.getQualificationTypeById(qualificationId);
        return new ResponseEntity<>(qualificationType, HttpStatus.OK);
    }

    
    @PostMapping("/qualification")
    public ResponseEntity<?> saveQualifications(@RequestBody List<QualificationType> qualificationsList, @RequestParam("username") String username) {
            String  saveDetails = qualificationTypeService.save_OR_Update_Qualification(qualificationsList, username);
            if("SAVED".equals(saveDetails)) {
            	return new ResponseEntity<>("Data Saved Successfully", HttpStatus.CREATED);
            }else if("WENT_WRONG".equals(saveDetails)) {
            	return new ResponseEntity<>("Error While Saving Data", HttpStatus.INTERNAL_SERVER_ERROR);
            }else if("UPDATED".equals(saveDetails)) {
            	return new ResponseEntity<>("User Details Updated", HttpStatus.OK);
            }
            	 return new ResponseEntity<>("User Data Not Found", HttpStatus.NOT_FOUND);
            
        
    }




    @DeleteMapping("/{qualificationId}")
    public ResponseEntity<Void> deleteQualificationType(@PathVariable long qualificationId) {
        qualificationTypeService.deleteQualificationType(qualificationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	
}
