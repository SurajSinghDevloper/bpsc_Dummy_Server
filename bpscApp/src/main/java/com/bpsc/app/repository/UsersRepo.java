package  com.bpsc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import  com.bpsc.app.model.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long>{
//	public NewCollegeRegistration findByCollegeEmail(String collegeEmailID);
    @Query("SELECT n FROM Users n WHERE n.emailID = :email")
    Users findByUserEmail(@Param("email") String email);

}
