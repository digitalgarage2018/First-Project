package org.project.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpBean {
	private String username;
	private String password;
	private String email;
	private String name;
	private String surname;
	private String born_date;
	private String born_place;

}