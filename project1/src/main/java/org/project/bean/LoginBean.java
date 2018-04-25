package org.project.bean;

public class LoginBean {
	private String username;
	private String password;
	private boolean isLogged;
 
	public LoginBean(String username, String password, boolean isLogged){
		this.username = username;
		this.password = password;
		this.isLogged = isLogged;
	}
 
	
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
}
