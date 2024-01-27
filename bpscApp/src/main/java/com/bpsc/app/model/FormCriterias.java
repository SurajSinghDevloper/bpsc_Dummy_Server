package com.bpsc.app.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FormCriterias implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long formCriteriaId;
	
	 private String isCitizenOfIndia;
	    private String isOriginOfBihar;
	    private String isSonOfFreedomFighter;
	    private String isEXServiceManOfArmy;
	    private String isRegServiceInBiharGov;
	    private String hasRequiredQualification;
	    private String c4;
	    private String v4;
	    private String c5;
	    private String v5;
	    private String c6;
	    private String v6;
	    private String c7;
	    private String v7;
	    private String c8;
	    private String v8;
	    private String c9;
	    private String isDone;
	    //10 is only for declaration part
	    private String aggreWithDeclaration;
	    private String userName;
	    
	    

	    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	    @JoinColumn(name = "advertismentNumber", referencedColumnName = "advertismentNumber", unique = true)
	    @JsonIgnore
	    private Vacany vacancy;
	    
		public long getFormCriteriaId() {
			return formCriteriaId;
		}



		public void setFormCriteriaId(long formCriteriaId) {
			this.formCriteriaId = formCriteriaId;
		}



		public String getIsCitizenOfIndia() {
			return isCitizenOfIndia;
		}



		public void setIsCitizenOfIndia(String isCitizenOfIndia) {
			this.isCitizenOfIndia = isCitizenOfIndia;
		}



		public String getIsOriginOfBihar() {
			return isOriginOfBihar;
		}



		public void setIsOriginOfBihar(String isOriginOfBihar) {
			this.isOriginOfBihar = isOriginOfBihar;
		}



		public String getIsSonOfFreedomFighter() {
			return isSonOfFreedomFighter;
		}



		public void setIsSonOfFreedomFighter(String isSonOfFreedomFighter) {
			this.isSonOfFreedomFighter = isSonOfFreedomFighter;
		}



		public String getIsEXServiceManOfArmy() {
			return isEXServiceManOfArmy;
		}



		public void setIsEXServiceManOfArmy(String isEXServiceManOfArmy) {
			this.isEXServiceManOfArmy = isEXServiceManOfArmy;
		}



		public String getIsRegServiceInBiharGov() {
			return isRegServiceInBiharGov;
		}



		public void setIsRegServiceInBiharGov(String isRegServiceInBiharGov) {
			this.isRegServiceInBiharGov = isRegServiceInBiharGov;
		}



		public String getHasRequiredQualification() {
			return hasRequiredQualification;
		}



		public void setHasRequiredQualification(String hasRequiredQualification) {
			this.hasRequiredQualification = hasRequiredQualification;
		}



		public String getC4() {
			return c4;
		}



		public void setC4(String c4) {
			this.c4 = c4;
		}



		public String getV4() {
			return v4;
		}



		public void setV4(String v4) {
			this.v4 = v4;
		}



		public String getC5() {
			return c5;
		}



		public void setC5(String c5) {
			this.c5 = c5;
		}



		public String getV5() {
			return v5;
		}



		public void setV5(String v5) {
			this.v5 = v5;
		}



		public String getC6() {
			return c6;
		}



		public void setC6(String c6) {
			this.c6 = c6;
		}



		public String getV6() {
			return v6;
		}



		public void setV6(String v6) {
			this.v6 = v6;
		}



		public String getC7() {
			return c7;
		}



		public void setC7(String c7) {
			this.c7 = c7;
		}



		public String getV7() {
			return v7;
		}



		public void setV7(String v7) {
			this.v7 = v7;
		}



		public String getC8() {
			return c8;
		}



		public void setC8(String c8) {
			this.c8 = c8;
		}



		public String getV8() {
			return v8;
		}



		public void setV8(String v8) {
			this.v8 = v8;
		}



		public String getC9() {
			return c9;
		}



		public void setC9(String c9) {
			this.c9 = c9;
		}

		public String getIsDone() {
			return isDone;
		}
		public void setIsDone(String isDone) {
			this.isDone = isDone;
		}



		public String getAggreWithDeclaration() {
			return aggreWithDeclaration;
		}



		public void setAggreWithDeclaration(String aggreWithDeclaration) {
			this.aggreWithDeclaration = aggreWithDeclaration;
		}







		public String getUserName() {
			return userName;
		}



		public void setUserName(String userName) {
			this.userName = userName;
		}



		public Vacany getVacancy() {
			return vacancy;
		}



		public void setVacancy(Vacany vacancy) {
	        this.vacancy = vacancy;
	        
	    }

	    
	    
		
	    
	    


}
