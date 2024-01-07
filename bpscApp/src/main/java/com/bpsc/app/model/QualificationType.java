package com.bpsc.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QualificationTypes")
public class QualificationType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long qualificationId;
	private String qualificationName;

	
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
	
	
}
