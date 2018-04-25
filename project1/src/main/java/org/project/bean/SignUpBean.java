package org.project.bean;

public class SignUpBean {
	private String username;
	private String password;
	private String email;
	private String name;
	private String surname;
	private String born_date;
	private String born_place;

public SignUpBean(String username, String password, String email, String name, String surname, String born_date, String born_place){
	this.username = username;
	this.password = password;
	this.email = email;
	this.name = name;
	this.surname = surname;
	this.born_date = born_date;
	this.born_place = born_place;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
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

public String getBorn_date() {
	return born_date;
}

public void setBorn_date(String born_date) {
	this.born_date = born_date;
}

public String getBorn_place() {
	return born_place;
}

public void setBorn_place(String born_place) {
	this.born_place = born_place;
}


}