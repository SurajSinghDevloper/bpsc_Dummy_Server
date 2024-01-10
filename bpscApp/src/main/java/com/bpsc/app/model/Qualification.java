package com.bpsc.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Qualifications")
public class Qualification {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qualificationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "qualification_type_id")
    private QualificationType qualificationType;

    private String institutionName;
    
    private String yearStarted;
    
    private String yearCompleted;
    
    private String specialization;

    private String marksScored;

	public Long getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(Long qualificationId) {
		this.qualificationId = qualificationId;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public QualificationType getQualificationType() {
		return qualificationType;
	}

	public void setQualificationType(QualificationType qualificationType) {
		this.qualificationType = qualificationType;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getYearStarted() {
		return yearStarted;
	}

	public void setYearStarted(String yearStarted) {
		this.yearStarted = yearStarted;
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
    
    
	
    
}
