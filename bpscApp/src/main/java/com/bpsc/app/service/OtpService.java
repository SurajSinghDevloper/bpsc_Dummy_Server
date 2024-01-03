package  com.bpsc.app.service;


public interface OtpService {
	
	public String sendOtpEmail(String email, String otp);
	
	public String generateOtp();
	
	public boolean otpVerification(String otp, String email);
	
	public boolean emailVerification(String email);
	
	public boolean otpflagChange( String email);
	
	public String sendOtpForForgetPassword(String email, String otp);

}
