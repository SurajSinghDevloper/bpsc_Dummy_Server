package com.bpsc.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "QualificationTypes")
public class QualificationType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long qualificationId;

    private String name;
    private String specialization;
    private String school;
    private String marks;
    private String year;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "username",referencedColumnName = "username")
	private UserMaster userMaster;

	public QualificationType() {
		// Default constructor logic, if needed
	}
	
	
	
	public QualificationType(String name, String specialization, String school, String marks, String year,
			UserMaster userMaster) {
		super();
		this.name = name;
		this.specialization = specialization;
		this.school = school;
		this.marks = marks;
		this.year = year;
		this.userMaster = userMaster;
	}



	public long getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(long qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public UserMaster getUserMaster() {
		return userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}


	

}
