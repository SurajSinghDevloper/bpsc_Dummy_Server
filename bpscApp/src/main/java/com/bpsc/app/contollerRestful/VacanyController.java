package com.bpsc.app.contollerRestful;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

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

import com.bpsc.app.model.AppliedForVacancy;
import com.bpsc.app.model.FormCriterias;
import com.bpsc.app.model.Vacany;
import com.bpsc.app.service.AppliedForVacancyService;
import com.bpsc.app.service.FormCriteriasService;
import com.bpsc.app.service.VacanyService;

@CrossOrigin
@RestController
@RequestMapping("/api/vac-bps")
public class VacanyController {

	@Autowired
	FormCriteriasService fcs;
	
	@Autowired
	VacanyService vservice;
	
	@Autowired
	AppliedForVacancyService afvs;
	
	
	@PostMapping("/new-vac")
	public ResponseEntity<?> saveVacancy(@ModelAttribute Vacany newVac){
		Vacany savedVac = vservice.saveVacancy(newVac);
		if(savedVac != null) {
			return ResponseEntity.ok("Vacancy Saved Successfully");
		}
		return ResponseEntity.internalServerError().body("Something went wrong");
	}
	
	@GetMapping("/found")
	public ResponseEntity<?> saveVacancy(){
		List<Vacany> foundVac = vservice.findAll();
		if(foundVac != null) {
			return ResponseEntity.ok(foundVac);
		}
		return ResponseEntity.internalServerError().body("Something went wrong");
	}
	
	 @PostMapping("/save/form-criteria")
	    public ResponseEntity<FormCriterias> saveFormCriteria(@ModelAttribute FormCriterias formCriterias,
	    		 @RequestParam("advNo") String advNo) {
		 
		 FormCriterias savedFormCriteria = fcs.saveFormCriteria(formCriterias, advNo);

	        if (savedFormCriteria != null) {
	            return new ResponseEntity<>(savedFormCriteria, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }
	 @GetMapping("/found-criteria")
		public ResponseEntity<?> exixtingCriteria(
		        @RequestParam("username") String username){
			FormCriterias foundCriteria = fcs.getByAdvNo(username);
			if(foundCriteria != null) {
				return ResponseEntity.ok(foundCriteria);
			}
			return ResponseEntity.internalServerError().body("Something went wrong");
		}
	 
	 @PostMapping("/create-criteria")
	    public ResponseEntity<String> createCriteria(@ModelAttribute Vacany vac) {
	        try {
	            String result = fcs.createCriteria(vac);

	            if ("SAVED".equals(result)) {
	                return new ResponseEntity<>("Criteria saved successfully", HttpStatus.CREATED);
	            } else if ("EXIST".equals(result)) {
	                return new ResponseEntity<>("Criteria already exists", HttpStatus.CONFLICT);
	            } else {
	                return new ResponseEntity<>("Failed to create criteria", HttpStatus.INTERNAL_SERVER_ERROR);
	            }
	        } catch (Exception e) {
	            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	 
	 
	 @PostMapping("/save-applied-details")
	    public ResponseEntity<AppliedForVacancy> saveAppliedForVacancy(@ModelAttribute AppliedForVacancy afv) {
	        AppliedForVacancy newAfv = afvs.saveAppliedForVacany(afv);
	        return newAfv != null
	                ? new ResponseEntity<>(newAfv, HttpStatus.CREATED)
	                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    @GetMapping("/getAll/{username}")
	    public ResponseEntity<List<AppliedForVacancy>> getAllApplied(@PathVariable String username) {
	        List<AppliedForVacancy> listOfVacancy = afvs.getAllApplied(username);
	        return listOfVacancy != null && !listOfVacancy.isEmpty()
	                ? new ResponseEntity<>(listOfVacancy, HttpStatus.OK)
	                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
}
