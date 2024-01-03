package  com.bpsc.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Otp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long otpID;
	private String otp;
	private String email;
	private String otpFlg;
	
	
	public long getOtpID() {
		return otpID;
	}
	public void setOtpID(long otpID) {
		this.otpID = otpID;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtpFlg() {
		return otpFlg;
	}
	public void setOtpFlg(String otpFlg) {
		this.otpFlg = otpFlg;
	}
	
	
	
}
