package org.project.bean;

import java.util.Date;

public class StudentBean {
	private long badgeNumber;
	private String name;
	private String surname;
	private String personalEmail;
	private String istitutionalEmail;
	private Date dateOfBirth;
	private long idPlainOfStudy;

	public StudentBean(){

	}

	public StudentBean(long badgeNumber, String name, String surname, String personalEmail, String istitutionalEmail, Date dateOfBirth) {
		this.badgeNumber = badgeNumber;
		this.name = name;
		this.surname = surname;
		this.personalEmail = personalEmail;
		this.istitutionalEmail = istitutionalEmail;
		this.dateOfBirth = dateOfBirth;
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

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
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

	public long getIdPlainOfStudy() {
		return idPlainOfStudy;
	}

	public void setIdPlainOfStudy(long idPlainOfStudy) {
		this.idPlainOfStudy = idPlainOfStudy;
	}
}
	
	