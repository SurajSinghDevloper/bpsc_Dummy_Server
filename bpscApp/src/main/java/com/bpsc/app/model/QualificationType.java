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

	

	private String qualificationName;

	private String institutionName;

	private String yearCompleted;

	private String specialization;

	private String marksScored;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "username",referencedColumnName = "username")
	private UserMaster userMaster;

	public QualificationType() {
		// Default constructor logic, if needed
	}

	public QualificationType(String qualificationName, String institutionName, String yearCompleted,
			String specialization, String marksScored, UserMaster userMaster) {
		super();
		this.qualificationName = qualificationName;
		this.institutionName = institutionName;
		this.yearCompleted = yearCompleted;
		this.specialization = specialization;
		this.marksScored = marksScored;
		this.userMaster = userMaster;
	}

	public long getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(long qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getQualificationName() {
		return qualificationName;
	}

	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getYearCompleted() {
		return yearCompleted;
	}

	public void setYearCompleted(String yearCompleted) {
		this.yearCompleted = yearCompleted;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getMarksScored() {
		return marksScored;
	}

	public void setMarksScored(String marksScored) {
		this.marksScored = marksScored;
	}

	public UserMaster getUserMaster() {
		return userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

}
