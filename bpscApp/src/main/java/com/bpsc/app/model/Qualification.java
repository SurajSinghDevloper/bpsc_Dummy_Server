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
    
    private int yearStarted;
    
    private int yearCompleted;

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

	public int getYearStarted() {
		return yearStarted;
	}

	public void setYearStarted(int yearStarted) {
		this.yearStarted = yearStarted;
	}

	public int getYearCompleted() {
		return yearCompleted;
	}

	public void setYearCompleted(int yearCompleted) {
		this.yearCompleted = yearCompleted;
	}
    
    
}
