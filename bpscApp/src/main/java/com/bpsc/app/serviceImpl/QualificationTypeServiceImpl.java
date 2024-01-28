package com.bpsc.app.serviceImpl;

import com.bpsc.app.repository.QualificationDocRepository;
import com.bpsc.app.repository.QualificationTypeRepository;
import com.bpsc.app.repository.UserMasterRepo;
import com.bpsc.app.service.QualificationTypeService;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bpsc.app.model.*;

@Service
public class QualificationTypeServiceImpl implements QualificationTypeService {
	@Autowired
	private QualificationTypeRepository qualificationTypeRepository;
	@Autowired
	UserMasterRepo umr;
	@Autowired
	private QualificationDocRepository qdr;

	@Override
	public List<QualificationType> getAllQualificationTypes() {
		return qualificationTypeRepository.findAll();
	}

	@Override
	public QualificationType getQualificationTypeById(long qualificationId) {
		return qualificationTypeRepository.findById(qualificationId)
				.orElseThrow(
						() -> new EntityNotFoundException("QualificationType not found with id: " + qualificationId));
	}

	@Override
	public QualificationType saveQualificationType(QualificationType qualificationType) {
		QualificationType qualification = new QualificationType();
		qualification.setSchool(qualificationType.getSchool());
		qualification.setName(qualificationType.getName());
		qualification.setMarks(qualificationType.getMarks());
		qualification.setSpecialization(qualificationType.getSpecialization());
		qualification.setYear(qualificationType.getYear());
		qualification.setUserMaster(qualificationType.getUserMaster());
		return qualificationTypeRepository.save(qualification);
	}

	@Override
	public String save_OR_Update_Qualification(List<QualificationType> qualificationsList, String username) {
		UserMaster userMaster = umr.findByUsername(username);
		List<QualificationType> existingQualifications = qualificationTypeRepository.findByUserMaster(userMaster);
		QualificationType qualificationType = null;
		if (existingQualifications == null || existingQualifications.isEmpty()) {
			// Save new qualifications
			for (QualificationType qualificationData : qualificationsList) {
						qualificationType = new QualificationType(
						qualificationData.getName(),
						qualificationData.getSpecialization(),
						qualificationData.getSchool(),
						qualificationData.getMarks(),
						qualificationData.getYear(),
						userMaster);
				qualificationTypeRepository.save(qualificationType);
			}
			if(qualificationType != null) {
				QualificationDoc doc = new QualificationDoc();
				doc.setQualificationType(qualificationType);
				doc.setUserMaster(userMaster);
				doc.setUserName(username);
				QualificationDoc savedDoc = qdr.save(doc);
				if(savedDoc !=null) {
					UserMaster user = umr.findByUsername(username);
					user.setQualificationDoc(savedDoc);
					umr.save(user);
				}
				
			}
			return "SAVED";
		} else {
			// Update existing qualifications
			List<QualificationType> updatedQualifications = new ArrayList<>();

			for (QualificationType existingQualification : existingQualifications) {
				for (QualificationType updatedQualification : qualificationsList) {
					if (existingQualification.getName().equals(updatedQualification.getName())) {
						// Update the existing qualification with data from the matching new
						// qualification
						existingQualification.setSchool(updatedQualification.getSchool());
						existingQualification.setMarks(updatedQualification.getMarks());
						existingQualification.setSpecialization(updatedQualification.getSpecialization());
						existingQualification.setYear(updatedQualification.getYear());

						// Add the updated qualification to the list
						updatedQualifications.add(existingQualification);
						break; // Break to avoid updating the same qualification multiple times
					}
				}
			}

			// Save all updated qualifications outside the loop
			if (!updatedQualifications.isEmpty()) {
				qualificationTypeRepository.saveAll(updatedQualifications);
				return "UPDATED";
			}
		}

		return "WENT_WRONG";
	}

	@Override
	public void deleteQualificationType(long qualificationId) {
		qualificationTypeRepository.deleteById(qualificationId);
	}
}
