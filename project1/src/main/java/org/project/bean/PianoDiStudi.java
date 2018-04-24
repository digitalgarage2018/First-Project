package org.project.bean;

import java.util.*;

public class PianoDiStudi {
	List <Long> iDEsami;
	long idPiano;//è anche la matricola dello studente
	public PianoDiStudi(List<Long> iDEsami, long idPiano) {
		super();
		this.iDEsami = iDEsami;
		this.idPiano = idPiano;
	}
	public List<Long> getiDEsami() {
		return iDEsami;
	}
	public void setiDEsami(List<Long> iDEsami) {
		this.iDEsami = iDEsami;
	}
	public long getIdPiano() {
		return idPiano;
	}
	public void setIdPiano(long idPiano) {
		this.idPiano = idPiano;
	}
	

}
