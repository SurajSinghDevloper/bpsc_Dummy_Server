package com.bpsc.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Qualifications")
public class QualificationDoc {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qualificationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToOne
    @JoinColumn(name = "qualification_type_id")
    private QualificationType qualificationType;
    
    private String tenthDoc;

    private String twelethDoc;
    
    private String ugDoc;
    
    private String pgDoc;
    
    private String otherDoc;

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
    
    
    
    

    
    

	
	
    
}
