package org.project.bean;

public class LoginBean{
	private String badgeNumber;
	private String password;
	private String istitutionalEmail;
	private String username;
	private String flagType;


	public LoginBean() {
	}

	public LoginBean(String username, String password){
		this.username = username;
		this.password = password;
	}

	public String getBadgeNumber() {
		return badgeNumber;
	}

	public void setBadgeNumber(String badgeNumber) {
		this.badgeNumber = badgeNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIstitutionalEmail() {
		return istitutionalEmail;
	}

	public void setIstitutionalEmail(String istitutionalEmail) {
		this.istitutionalEmail = istitutionalEmail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFlagType() {
		return flagType;
	}

	public void setFlagType(String flagType) {
		this.flagType = flagType;
	}
}
