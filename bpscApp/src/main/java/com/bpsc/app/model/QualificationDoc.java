package com.bpsc.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "QualificationsDoc")
public class QualificationDoc {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qualificationId;
    
    @OneToOne
    @JoinColumn(name = "qualificationId")
    private QualificationType qualificationType;
    
    private String tenthDoc;

    private String twelethDoc;
    
    private String ugDoc;
    
    private String pgDoc;
    
    private String otherDoc;
    
    private String userName;
    
    @JsonIgnore
    @OneToOne(mappedBy = "qualificationDoc")// Specify the actual column name used in the database
    private UserMaster userMaster;
    
    
    

	public Long getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(Long qualificationId) {
		this.qualificationId = qualificationId;
	}

	public QualificationType getQualificationType() {
		return qualificationType;
	}

	public void setQualificationType(QualificationType qualificationType) {
		this.qualificationType = qualificationType;
	}

	public String getTenthDoc() {
		return tenthDoc;
	}

	public void setTenthDoc(String tenthDoc) {
		this.tenthDoc = tenthDoc;
	}

	public String getTwelethDoc() {
		return twelethDoc;
	}

	public void setTwelethDoc(String twelethDoc) {
		this.twelethDoc = twelethDoc;
	}

	public String getUgDoc() {
		return ugDoc;
	}

	public void setUgDoc(String ugDoc) {
		this.ugDoc = ugDoc;
	}

	public String getPgDoc() {
		return pgDoc;
	}

	public void setPgDoc(String pgDoc) {
		this.pgDoc = pgDoc;
	}

	public String getOtherDoc() {
		return otherDoc;
	}

	public void setOtherDoc(String otherDoc) {
		this.otherDoc = otherDoc;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserMaster getUserMaster() {
		return userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}
    
    
    
    

    
    

	
	
    
}
