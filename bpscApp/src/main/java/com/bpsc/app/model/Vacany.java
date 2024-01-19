package com.bpsc.app.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Vacany {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slno;
	
	private String advertismentNumber;
	private String nameOfExam;
	private String formOpening;
	private String formClosing;
	private String lastPaymentDate;
	private String vacanyDoc;
	private String feesOfVacany;
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
	public String getFeesOfVacany() {
		return feesOfVacany;
	}
	public void setFeesOfVacany(String feesOfVacany) {
		this.feesOfVacany = feesOfVacany;
	}
	
	
}
