package com.bpsc.app.contollerRestful;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bpsc.app.model.QualificationType;
import com.bpsc.app.model.UserMaster;
import com.bpsc.app.repository.UserMasterRepo;
import com.bpsc.app.service.QualificationTypeService;

@RestController
@RequestMapping("/api/qualification-types")
public class QualificationTypeController {
	
	@Autowired
    private QualificationTypeService qualificationTypeService;
	@Autowired
	private UserMasterRepo umr;
	
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

    
//   @PostMapping("/qualification")
//   public ResponseEntity<?> saveQualifications(@RequestBody List<Map<String, Object>> qualificationsList,@RequestParam("username") String username) {
//       try {
//       	UserMaster userMaster = umr.findByUsername(username);
//       	if(userMaster ==null) {
//       		return new  ResponseEntity<>("User Data Not Found",HttpStatus.NOT_FOUND);
//       	}
//           for (Map<String, Object> qualificationData : qualificationsList) {
//               String qualificationName = (String) qualificationData.get("name");
//               String specialization = (String) qualificationData.get("specialization");
//               String institutionName = (String) qualificationData.get("school");
//               String marks = (String) qualificationData.get("marks");
//               String yearCompleted = (String) qualificationData.get("year");
//
//               QualificationType qualificationType = new QualificationType(qualificationName, specialization, institutionName, marks, yearCompleted, userMaster);
//               qualificationTypeService.saveQualificationType(qualificationType);
//           }
//
//           return new  ResponseEntity<>("Data Saved Successfully",HttpStatus.CREATED);
//       } catch (Exception e) {
//           return new ResponseEntity<>("Error Occured while saving data",HttpStatus.INTERNAL_SERVER_ERROR);
//       }
//   }

    
    @PostMapping("/qualification")
    public ResponseEntity<?> saveQualifications(@RequestBody List<QualificationType> qualificationsList, @RequestParam("username") String username) {
        try {
            UserMaster userMaster = umr.findByUsername(username);
            if (userMaster == null) {
                return new ResponseEntity<>("User Data Not Found", HttpStatus.NOT_FOUND);
            }

            for (QualificationType qualificationData : qualificationsList) {
                String qualificationName = qualificationData.getName();
                String specialization = qualificationData.getSpecialization();
                String institutionName = qualificationData.getSchool();
                String marks = qualificationData.getMarks();
                String yearCompleted = qualificationData.getYear();

                QualificationType qualificationType = new QualificationType(qualificationName, specialization, institutionName, marks, yearCompleted, userMaster);
                qualificationTypeService.saveQualificationType(qualificationType);
            }

            return new ResponseEntity<>("Data Saved Successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Occurred while saving data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @DeleteMapping("/{qualificationId}")
    public ResponseEntity<Void> deleteQualificationType(@PathVariable long qualificationId) {
        qualificationTypeService.deleteQualificationType(qualificationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	
}
