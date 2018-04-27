package org.project.bean;

public class LoginBean{
	private String nMatricola;
	private String password;
	private String email;
	private String username;
	private String type;


	public LoginBean(String username, String password){
		//if(username.contains("unimarina.it")) {this.email=username;}
		//else {this.nMatricola = username;}
		this.username=username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getnMatricola() {
		return nMatricola;
	}

	public void setnMatricola(String nMatricola) {
		this.nMatricola = nMatricola;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
