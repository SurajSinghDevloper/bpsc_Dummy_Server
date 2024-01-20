package com.bpsc.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bpsc.app.model.QualificationDoc;
import com.bpsc.app.model.QualificationType;
import com.bpsc.app.model.UserMaster;
import com.bpsc.app.repository.QualificationDocRepository;
import com.bpsc.app.repository.QualificationTypeRepository;
import com.bpsc.app.repository.UserMasterRepo;
import com.bpsc.app.service.QualificationDocService;
import com.bpsc.app.util.FileUpload;

@Service
public class QualificationDocServiceImpl implements QualificationDocService{
     @Autowired
    private FileUpload fileService;
     @Autowired
    private QualificationDocRepository qfdr;
     @Autowired
     private QualificationTypeRepository qftr;
     @Autowired
     private UserMasterRepo umr;

    @Override
    public String saveQualificationDocument(MultipartFile pdf, String documentType, String userName) {
    	
        	
    	try {
            String fileName = fileService.uploadFile(pdf, userName, documentType);

            QualificationDoc qualificationDoc = qfdr.findByUserName(userName);
            QualificationDoc savedDoc;
            switch (documentType) {
                case "10":
                    qualificationDoc.setTenthDoc(fileName);
                    savedDoc = qfdr.save(qualificationDoc);
                    break;
                case "12":
                    qualificationDoc.setTwelethDoc(fileName);
                    savedDoc = qfdr.save(qualificationDoc);
                    break;
                case "UG":
                    qualificationDoc.setUgDoc(fileName);
                    savedDoc = qfdr.save(qualificationDoc);
                    break;
                case "PG":
                    qualificationDoc.setPgDoc(fileName);
                    savedDoc = qfdr.save(qualificationDoc);
                    break;
                case "OTHER":
                    qualificationDoc.setOtherDoc(fileName);
                    savedDoc = qfdr.save(qualificationDoc);
                    break;
                default:
                    // Handle unexpected document type
                    throw new IllegalArgumentException("Invalid document type: " + documentType);
            }

             
            if(savedDoc != null) {
            	 return fileName;
            }
           
        } catch (Exception e) {
            // Handle exceptions, log, or rethrow as needed
            e.printStackTrace();
            throw new RuntimeException("Unexpected error while saving qualification document.");
        }
		return null;
    }

    
    @Override
    public String delteQualificationDocument(long qualificationId,  String filename,String documentType) {
        QualificationDoc existingQualificationDoc = qfdr.findById(qualificationId).orElse(null);

        if (existingQualificationDoc != null) {
           fileService.deleteFile(filename);

            switch (documentType) {
                case "10":
                    existingQualificationDoc.setTenthDoc("");
                    break;
                case "12":
                    existingQualificationDoc.setTwelethDoc("");
                    break;
                case "UG":
                    existingQualificationDoc.setUgDoc("");
                    break;
                case "PG":
                    existingQualificationDoc.setPgDoc("");
                    break;
                case "otherDoc":
                    existingQualificationDoc.setOtherDoc("");
                    break;
                default:
                    // Handle unexpected document type
                    return "NULL";
            }
            qfdr.save(existingQualificationDoc);
            return "DELTED";
        }

        return "WENT_WRONG";
    }
    
    @Override
    public QualificationDoc findByUserName (String username) {
    	QualificationDoc qualificationDoc = qfdr.findByUserName(username);
    	if(qualificationDoc != null ) {
    		return qualificationDoc;
    	}
    	return null;
    }
}
