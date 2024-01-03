package  com.bpsc.app.serviceImpl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import  com.bpsc.app.model.Users;
import  com.bpsc.app.model.Otp;
import  com.bpsc.app.repository.UsersRepo;
import  com.bpsc.app.repository.OtpRepo;
import  com.bpsc.app.service.OtpService;

@Service
public class OtpServiceImpl implements OtpService{

	@Autowired
    private JavaMailSender javaMailSender;
	@Autowired
	private OtpRepo otpRepo;
	@Autowired
	UsersRepo userRepo;
	
	@Override
	 public String generateOtp() {
	        Random random = new Random();
	        int otp = 100000 + random.nextInt(900000);
	        return String.valueOf(otp);
	    }

	@Override
	public String sendOtpEmail(String email, String otp) {
		  Users college = userRepo.findByUserEmail(email);
		  if(college ==null) {
			  try {
		            MimeMessage message = javaMailSender.createMimeMessage();
		            MimeMessageHelper helper = new MimeMessageHelper(message, true);

		            helper.setTo(email);
		            helper.setSubject("Your OTP Code");
		            
		            String htmlContent = "<!DOCTYPE html>\r\n"
		            		+ "<html>\r\n"
		            		+ "<head>\r\n"
		            		+ "    <title>OTP Verification</title>\r\n"
		            		+ "</head>\r\n"
		            		+ "<body>\r\n"
		            		+ "    <p>Hello,</p>\r\n"
		            		+ "    \r\n"
		            				+ "    \r\n"
		            				+ "    <p>Please use this code to complete the verification process. Note that this code is only valid for a short period of time.</p>\r\n"
		            				+ "    \r\n"
				            		+ "    <p>Your OTP code for verification is: <strong> <h2>" + otp + "</h2> </strong></p>\r\n"
		            				+ "    <p>If you did not request this OTP, please ignore this email.</p>\r\n"
		            				+ "    \r\n"
		            				+ "    <p>Thank you for using our service.</p>\r\n"
		            				+ "    \r\n"
		            				+ "    <p>Best regards,</p>\r\n"
		            				+ "    <p>Your Company Name</p>\r\n"
		            				+ "</body>\r\n"
		            				+ "</html>";
		            helper.setText(htmlContent, true);

		            javaMailSender.send(message);
		            Otp newOtp = new Otp();
		            newOtp.setEmail(email);
		            newOtp.setOtp(otp);
		            newOtp.setOtpFlg("0");
		            Otp saveOtp = otpRepo.save(newOtp);
		            if(saveOtp != null) {
		            	return "true";	
		            }
		            return "false";
		        } catch (MessagingException e) {
		            e.printStackTrace();
		            return "false";
		        }
		  }
        return "Email Already Register";
    }
	
	@Override
	public boolean emailVerification(String email) {
	    Users college = userRepo.findByUserEmail(email);

	    if (college != null) {
	        String registeredEmail = college.getEmailID();	        
	        if (email.equals(registeredEmail)) {
	            return true;
	        } else {
	            return false;
	        }
	    } else {
	        return false;
	    }
	}

	
	@Override
	public boolean otpVerification(String otp, String email) {
	    List<Otp> otps = otpRepo.getOtpByEmailOrderByDesc(email);
	    
	    if (otps != null && !otps.isEmpty()) {
	        Otp otpEntity = otps.get(0); // Get the most recent OTP

	        String otpStored = otpEntity.getOtp();
	        
	        if (otp.equals(otpStored)) {
	            otpEntity.setOtpFlg("1");
	            otpRepo.save(otpEntity);
	            return true;
	        }
	    }
	    
	    return false;
	}

	@Override
	public boolean otpflagChange( String email) {
	    List<Otp> otps = otpRepo.getOtpByEmailOrderByDesc(email);
	    
	    if (otps != null ) {
	        Otp otpEntity = otps.get(0); 
	        
	        if (otpEntity !=null) {
	            otpEntity.setOtpFlg("1");
	            otpRepo.save(otpEntity);
	            return true;
	        }
	    }
	    
	    return false;
	}
	
	
	@Override
	public String sendOtpForForgetPassword(String email, String otp) {
		  Users college = userRepo.findByUserEmail(email);
		  if(college !=null) {
			  try {
		            MimeMessage message = javaMailSender.createMimeMessage();
		            MimeMessageHelper helper = new MimeMessageHelper(message, true);

		            helper.setTo(email);
		            helper.setSubject("Your OTP Code");
		            
		            String htmlContent = "<!DOCTYPE html>\r\n"
		            		+ "<html>\r\n"
		            		+ "<head>\r\n"
		            		+ "    <title>OTP Verification</title>\r\n"
		            		+ "</head>\r\n"
		            		+ "<body>\r\n"
		            		+ "    <p>Hello,</p>\r\n"
		            		+ "    \r\n"
		            				+ "    \r\n"
		            				+ "    <p>Please use this code to complete the verification process. Note that this code is only valid for a short period of time.</p>\r\n"
		            				+ "    \r\n"
				            		+ "    <p>Your OTP code for verification is: <strong> <h2>" + otp + "</h2> </strong></p>\r\n"
		            				+ "    <p>If you did not request this OTP, please ignore this email.</p>\r\n"
		            				+ "    \r\n"
		            				+ "    <p>Thank you for using our service.</p>\r\n"
		            				+ "    \r\n"
		            				+ "    <p>Best regards,</p>\r\n"
		            				+ "    <p>Your Company Name</p>\r\n"
		            				+ "</body>\r\n"
		            				+ "</html>";
		            helper.setText(htmlContent, true);

		            javaMailSender.send(message);
		            Otp newOtp = new Otp();
		            newOtp.setEmail(email);
		            newOtp.setOtp(otp);
		            newOtp.setOtpFlg("0");
		            Otp saveOtp = otpRepo.save(newOtp);
		            if(saveOtp != null) {
		            	return "true";	
		            }
		            return "false";
		        } catch (MessagingException e) {
		            e.printStackTrace();
		            return "false";
		        }
		  }
        return "Email Not Found";
    }
}
