package com.bpsc.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppliedForVacancy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long appliedId;
	
	private String appliedFor;
	private String paymentStatus;
	private String isCompleted;
	private String isVarified;
	private String vacancyType;
	private String advertismentNumber;
	private String orderId;
	private String mobileNo;
	private String userName;
	private String paymentAmount;
	
	
	public Long getAppliedId() {
		return appliedId;
	}
	public void setAppliedId(Long appliedId) {
		this.appliedId = appliedId;
	}
	public String getAppliedFor() {
		return appliedFor;
	}
	public void setAppliedFor(String appliedFor) {
		this.appliedFor = appliedFor;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(String isCompleted) {
		this.isCompleted = isCompleted;
	}
	public String getIsVarified() {
		return isVarified;
	}
	public void setIsVarified(String isVarified) {
		this.isVarified = isVarified;
	}
	public String getVacancyType() {
		return vacancyType;
	}
	public void setVacancyType(String vacancyType) {
		this.vacancyType = vacancyType;
	}
	public String getAdvertismentNumber() {
		return advertismentNumber;
	}
	public void setAdvertismentNumber(String advertismentNumber) {
		this.advertismentNumber = advertismentNumber;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	
}
