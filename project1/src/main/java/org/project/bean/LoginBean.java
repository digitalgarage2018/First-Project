package org.project.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //noargsconstructor per costruttore
public class LoginBean {
	private String username;
	private String password;
	private boolean isLogged;

}
