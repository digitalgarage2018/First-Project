package org.project.bean;

import java.util.ArrayList;
import java.util.Date;

public class ProfessorBean {
	private long badgeNumber;
	private String name;
	private String surname;
	private String istitutionalEmail;
	private Date dateOfBirth;

	private ArrayList<ExamBean> exams;

	public ProfessorBean(){

	}

	public ProfessorBean(long badgeNumber, String name, String surname, String istitutionalEmail, Date dateOfBirth, ArrayList<ExamBean> exams) {
		this.badgeNumber = badgeNumber;
		this.name = name;
		this.surname = surname;
		this.istitutionalEmail = istitutionalEmail;
		this.dateOfBirth = dateOfBirth;
		this.exams = exams;
	}

	public long getBadgeNumber() {
		return badgeNumber;
	}

	public void setBadgeNumber(long badgeNumber) {
		this.badgeNumber = badgeNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getIstitutionalEmail() {
		return istitutionalEmail;
	}

	public void setIstitutionalEmail(String istitutionalEmail) {
		this.istitutionalEmail = istitutionalEmail;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public ArrayList<ExamBean> getExams() {
		return exams;
	}

	public void setExams(ArrayList<ExamBean> exams) {
		this.exams = exams;
	}
}
