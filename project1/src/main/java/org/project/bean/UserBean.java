package org.project.bean;

import java.io.Serializable;
import java.util.Date;

public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String name, surname;
	private Date birth;
	private WalletBean wallet=null;
	
	
	public UserBean(String user, String pass) {
		this.username=user;
		this.password=pass;
	}
	
	public UserBean(String user, String pass, WalletBean wallet) {
		this.username=user;
		this.password=pass;
		this.wallet=wallet;
	}
	
	
	public UserBean(String user, String pass, String name, String surname, Date birth, WalletBean wallet) {
		this.username = user;
		this.password = pass;
		this.name = name;
		this.surname = surname;
		this.birth = birth;
		this.wallet=wallet;
	}

	
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Date getBirth() {
		return birth;
	}

	public WalletBean getWallet() {
		return wallet;
	}

	public void setUser(String user) {
		this.username = user;
	}

	public void setPass(String pass) {
		this.password = pass;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public void setWallet(WalletBean wallet) {
		this.wallet = wallet;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((password == null) ? 0 : password.hashCode());
//		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
//		result = prime * result + ((username == null) ? 0 : username.hashCode());
//		result = prime * result + ((wallet == null) ? 0 : wallet.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		if (birth == null) {
//			if (other.birth != null)
//				return false;
//		} else if (!birth.equals(other.birth))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (password == null) {
//			if (other.password != null)
//				return false;
//		} else if (!password.equals(other.password))
//			return false;
//		if (surname == null) {
//			if (other.surname != null)
//				return false;
//		} else if (!surname.equals(other.surname))
//			return false;
//		if (username == null) {
//			if (other.username != null)
//				return false;
//		} else if (!username.equals(other.username))
//			return false;
//		if (wallet == null) {
//			if (other.wallet != null)
//				return false;
//		} else if (!wallet.equals(other.wallet))
//			return false;
//		return true;
//	}

	
	
}
