package com.bpsc.app.serviceImpl;

import com.bpsc.app.repository.QualificationTypeRepository;
import com.bpsc.app.service.QualificationTypeService;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpsc.app.model.*;

@Service
public class QualificationTypeServiceImpl implements QualificationTypeService{
	 	@Autowired
	    private QualificationTypeRepository qualificationTypeRepository;

	 	@Override
	    public List<QualificationType> getAllQualificationTypes() {
	        return qualificationTypeRepository.findAll();
	    }
	 	@Override
	    public QualificationType getQualificationTypeById(long qualificationId) {
	        return qualificationTypeRepository.findById(qualificationId)
	                .orElseThrow(() -> new EntityNotFoundException("QualificationType not found with id: " + qualificationId));
	    }
	 	@Override
	    public QualificationType saveQualificationType(QualificationType qualificationType) {
	        return qualificationTypeRepository.save(qualificationType);
	    }
	 	@Override
	    public void deleteQualificationType(long qualificationId) {
	        qualificationTypeRepository.deleteById(qualificationId);
	    }
}
