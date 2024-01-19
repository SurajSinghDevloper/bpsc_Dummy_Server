package com.bpsc.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class UserMaster implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slno;
    @Column(unique = true)
    private String username;
    @OneToOne
//    @JoinColumn(referencedColumnName = "userName", insertable = false, updatable = false)
    private Users users;
	private String firstname;
	private String middlename;
	private String lastname;
	private String dob;
	private String fname;
	private String mname;
	private String email;
	private String gender;
	private String nationality;
	private String maritialStatus;
	private String mobile;
	private String aadharNo;
	private String state;
	private String district;
	private String pincode;
	private String cityOrVillage;
	private String address;
	private String religion;
	private String category;
	private String domicile;
	private String disablity;
	private String disablityType;
	private String disablityRemark;
	private String identification;
	private String pLanguage;
	private String locationType;
	private String appliedFor;
	private String permanentAddress;
	private String aadharDoc;
	private String domicileDoc;
	private String incomeProfDoc;
	private String castProfDoc;
	private String birthDoc;
	private String OtherDoc;
	@OneToMany(mappedBy = "userMaster")
    private List<QualificationType> qualificationType;


	public Long getSlno() {
		return slno;
	}

	public void setSlno(Long slno) {
		this.slno = slno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getMaritialStatus() {
		return maritialStatus;
	}

	public void setMaritialStatus(String maritialStatus) {
		this.maritialStatus = maritialStatus;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCityOrVillage() {
		return cityOrVillage;
	}

	public void setCityOrVillage(String cityOrVillage) {
		this.cityOrVillage = cityOrVillage;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setAppliedFor(String appliedFor) {
		this.appliedFor = appliedFor;
	}

	public String getAppliedFor() {
		return appliedFor;
	}

	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	public String getDisablity() {
		return disablity;
	}

	public void setDisablity(String disablity) {
		this.disablity = disablity;
	}

	public String getDisablityType() {
		return disablityType;
	}

	public void setDisablityType(String disablityType) {
		this.disablityType = disablityType;
	}

	public String getDisablityRemark() {
		return disablityRemark;
	}

	public void setDisablityRemark(String disablityRemark) {
		this.disablityRemark = disablityRemark;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getpLanguage() {
		return pLanguage;
	}

	public void setpLanguage(String pLanguage) {
		this.pLanguage = pLanguage;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public List<QualificationType> getQualificationType() {
		return qualificationType;
	}

	public void setQualificationType(List<QualificationType> qualificationType) {
		this.qualificationType = qualificationType;
	}

	public String getAadharDoc() {
		return aadharDoc;
	}

	public void setAadharDoc(String aadharDoc) {
		this.aadharDoc = aadharDoc;
	}

	public String getDomicileDoc() {
		return domicileDoc;
	}

	public void setDomicileDoc(String domicileDoc) {
		this.domicileDoc = domicileDoc;
	}

	public String getIncomeProfDoc() {
		return incomeProfDoc;
	}

	public void setIncomeProfDoc(String incomeProfDoc) {
		this.incomeProfDoc = incomeProfDoc;
	}

	public String getCastProfDoc() {
		return castProfDoc;
	}

	public void setCastProfDoc(String castProfDoc) {
		this.castProfDoc = castProfDoc;
	}

	public String getBirthDoc() {
		return birthDoc;
	}

	public void setBirthDoc(String birthDoc) {
		this.birthDoc = birthDoc;
	}

	public String getOtherDoc() {
		return OtherDoc;
	}

	public void setOtherDoc(String otherDoc) {
		OtherDoc = otherDoc;
	}

	
	
	
	
}
