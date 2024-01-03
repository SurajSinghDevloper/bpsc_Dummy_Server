package  com.bpsc.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import  com.bpsc.app.model.Otp;

public interface OtpRepo  extends JpaRepository<Otp, Long> {
	@Query("SELECT o FROM Otp o WHERE o.email = :email ORDER BY o.id DESC")
	public List<Otp> getOtpByEmailOrderByDesc(@Param("email")String email);
	
	@Query("SELECT o FROM Otp o WHERE o.otp = :otp ORDER BY o.id DESC")
	public List<Otp> getEmailByOtpOrderByDesc(@Param("otp") String otp);

}
