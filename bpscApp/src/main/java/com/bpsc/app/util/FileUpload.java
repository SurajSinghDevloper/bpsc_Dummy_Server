package com.bpsc.app.util;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.persistence.EntityManager;

@Service
public class FileUpload {
    @Value("${user.image.upload.path}")
    private String fileUploadPath;



    
    public String uploadFile(MultipartFile pdfFile, String userName, String docType) {
        // Check if the uploaded file is not empty
        if (!pdfFile.isEmpty()) {
            try {
                // Specify the directory where you want to save the PDF files
                String uploadDir = fileUploadPath;

                // Create the directory if it doesn't exist
                File dir = new File(uploadDir);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                // Generate a unique filename using UUID and user information
                String originalFileName = pdfFile.getOriginalFilename();
                String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                String uniqueFileName = docType + "_" + userName + "_" +fileExtension;

                // Create the file path for the unique file
                String filePath = uploadDir + File.separator + uniqueFileName;
                File dest = new File(filePath);

                // Save the PDF file with the unique filename
                pdfFile.transferTo(dest);

                return uniqueFileName;
            } catch (IOException e) {
                // Handle file upload exceptions
                return "Upload failed: " + e.getMessage();
            }
        } else {
            return "File is empty!";
        }
    }
    
    
    
   

    
    
    
    
    public String deleteFile(String fileName) {
        // Specify the directory where you want to delete the file
        String uploadDir = fileUploadPath;

        // Create the file path for the file to be deleted
        String filePath = uploadDir + File.separator + fileName;
        Path path = Paths.get(filePath);

        try {
            // Delete the file
            Files.delete(path);
            return "File deleted successfully";
        } catch (IOException e) {
            // Handle file deletion exceptions
            return "Failed to delete file: " + e.getMessage();
        }
    }
    
}
