package  com.bpsc.app.configuration;

import  com.bpsc.app.model.Users;

public class LoginResponse {
	private String token;
	private Users userDetails;
	

	public LoginResponse(String token, Users userDetails) {
		this.token = token;
		this.userDetails = userDetails;

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Users getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Users userDetails) {
		this.userDetails = userDetails;
	}

}
