package com.bpsc.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Marks")
public class Marks {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long marksId;

	    @ManyToOne
	    @JoinColumn(name = "userId")
	    private Users users;

	    @ManyToOne
	    @JoinColumn(name = "subjectId")
	    private Subject subject;

	    private double marksObtained;
	    private int marksYear;
		public Long getMarksId() {
			return marksId;
		}
		public void setMarksId(Long marksId) {
			this.marksId = marksId;
		}
		public Users getUsers() {
			return users;
		}
		public void setUsers(Users users) {
			this.users = users;
		}
		public Subject getSubject() {
			return subject;
		}
		public void setSubject(Subject subject) {
			this.subject = subject;
		}
		public double getMarksObtained() {
			return marksObtained;
		}
		public void setMarksObtained(double marksObtained) {
			this.marksObtained = marksObtained;
		}
		public int getMarksYear() {
			return marksYear;
		}
		public void setMarksYear(int marksYear) {
			this.marksYear = marksYear;
		}
	    
	    
}
