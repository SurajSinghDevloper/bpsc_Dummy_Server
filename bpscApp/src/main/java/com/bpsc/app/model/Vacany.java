package com.bpsc.app.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Vacancy")
public class Vacany  implements Serializable{
	


	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long slno;
	
	@Id
	private String advertismentNumber;
	private String nameOfExam;
	private String formOpening;
	private String formClosing;
	private String lastPaymentDate;
	private String vacanyDoc;
	private String seatForVacancy;
	private String feesOfVacancy;
	private String totalSeats;
	private String reservedSeats;
	private String vacancyType;
	private String userName;
	
	
//	@OneToOne(mappedBy = "vacancy", fetch = FetchType.EAGER)
//    
//    private FormCriterias criteria;
	@OneToOne(mappedBy = "vacancy", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FormCriterias criteria;
	
	public Long getSlno() {
		return slno;
	}
	public void setSlno(Long slno) {
		this.slno = slno;
	}
	public String getAdvertismentNumber() {
		return advertismentNumber;
	}
	public void setAdvertismentNumber(String advertismentNumber) {
		this.advertismentNumber = advertismentNumber;
	}
	public String getNameOfExam() {
		return nameOfExam;
	}
	public void setNameOfExam(String nameOfExam) {
		this.nameOfExam = nameOfExam;
	}
	public String getFormOpening() {
		return formOpening;
	}
	public void setFormOpening(String formOpening) {
		this.formOpening = formOpening;
	}
	public String getFormClosing() {
		return formClosing;
	}
	public void setFormClosing(String formClosing) {
		this.formClosing = formClosing;
	}
	public String getLastPaymentDate() {
		return lastPaymentDate;
	}
	public void setLastPaymentDate(String lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}
	public String getVacanyDoc() {
		return vacanyDoc;
	}
	public void setVacanyDoc(String vacanyDoc) {
		this.vacanyDoc = vacanyDoc;
	}
	public String getSeatForVacancy() {
		return seatForVacancy;
	}
	public void setSeatForVacancy(String seatForVacancy) {
		this.seatForVacancy = seatForVacancy;
	}
	public String getFeesOfVacancy() {
		return feesOfVacancy;
	}
	public void setFeesOfVacancy(String feesOfVacancy) {
		this.feesOfVacancy = feesOfVacancy;
	}
	public String getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(String totalSeats) {
		this.totalSeats = totalSeats;
	}
	public String getReservedSeats() {
		return reservedSeats;
	}
	public void setReservedSeats(String reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	public String getVacancyType() {
		return vacancyType;
	}
	public void setVacancyType(String vacancyType) {
		this.vacancyType = vacancyType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public FormCriterias getCriteria() {
		return criteria;
	}
	public void setCriteria(FormCriterias criteria) {
		this.criteria = criteria;
        
	}
	
	
	
}
