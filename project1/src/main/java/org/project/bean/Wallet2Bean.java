package org.project.bean;

import java.io.Serializable;

public class Wallet2Bean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	/*
	 * invece di un semplice double
	 * metodo alla Gianmarco come buona norma
	 * ottengo il tutto in una botta con getCredit
	 */
	private long creditUnit;
	private int creditDecimal;
	
	
	public Wallet2Bean() {
		creditUnit = 0;
		creditDecimal = 0;	
	}

	
	public Wallet2Bean(long creditUnit, int creditDecimal) {
		super();
		this.creditUnit = creditUnit;
		this.creditDecimal = creditDecimal;
	}


	public long getCreditUnit() {
		return creditUnit;
	}


	public int getCreditDecimal() {
		return creditDecimal;
	}
	
	public double getCredit() {
		return (double)creditUnit + creditDecimal/100.0;
	}

	public void setCreditUnit(long creditUnit) {
		this.creditUnit = creditUnit;
	}



	public void setCreditDecimal(int creditDecimal) {
		this.creditDecimal = creditDecimal;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + creditDecimal;
		result = prime * result + (int) (creditUnit ^ (creditUnit >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wallet2Bean other = (Wallet2Bean) obj;
		if (creditDecimal != other.creditDecimal)
			return false;
		if (creditUnit != other.creditUnit)
			return false;
		return true;
	}







	



	
}
