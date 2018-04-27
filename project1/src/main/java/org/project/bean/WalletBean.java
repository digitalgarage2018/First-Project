/*
 ============================================================================
 Name        : WalletBean.java
 Author      : Alessio Onori
 Version     : 1.0
 Copyright   : Your copyright notice
 Description : Bean per modellare il portafoglio.
 	da migliorare l'attributo credit che non può essere 
 	un semplice double.
 ============================================================================
 */

package org.project.bean;

import java.io.Serializable;

public class WalletBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private int id = -1; //gestito da AutoIncrement
	private int idUser;
	private double credit;
	
	public WalletBean(double credit) {
		super();
		this.credit=credit;
	}
	

	public WalletBean(int idUser, double credit) {
		super();
		this.idUser = idUser;
		this.credit = credit;
	}


	public int getId() {
		return id;
	}

	public int getIdUser() {
		return idUser;
	}

	public double getCredit() {
		return credit;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public void setCredit(double credit) {
		this.credit = credit;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		long temp;
//		temp = Double.doubleToLongBits(credit);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
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
//		Wallet other = (Wallet) obj;
//		if (Double.doubleToLongBits(credit) != Double.doubleToLongBits(other.credit))
//			return false;
//		return true;
//	}

	



	
}
