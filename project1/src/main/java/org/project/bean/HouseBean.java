package org.project.bean;

import java.io.Serializable;

public class HouseBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String indirizzo; //da esplicitare
	private double costo;
	/*
	 * attributi da aggiungere bene
	 * per la ricerca, metratura, classe energetica, ecc.
	 */
	

	public HouseBean(String indirizzo, double costo) {
		super();
		this.indirizzo = indirizzo;
		this.costo = costo;
	}



	public String getIndirizzo() {
		return indirizzo;
	}


	public double getCosto() {
		return costo;
	}


	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}


	public void setCosto(double costo) {
		this.costo = costo;
	}



//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		long temp;
//		temp = Double.doubleToLongBits(costo);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
//		return result;
//	}
//
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		House other = (House) obj;
//		if (Double.doubleToLongBits(costo) != Double.doubleToLongBits(other.costo))
//			return false;
//		if (indirizzo == null) {
//			if (other.indirizzo != null)
//				return false;
//		} else if (!indirizzo.equals(other.indirizzo))
//			return false;
//		return true;
//	}



	

	


	
}
