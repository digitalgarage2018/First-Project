package org.project.bean;

import java.util.Date;

public class StudentBean {
	private long nMatricola;
	private String nome;
	private String cognome;
	private String email;
	private Date dataNascita;
	private long pianoId;

	public StudentBean(){}

	public StudentBean(long nMatricola, String nome, String cognome, String email, Date dataNascita, long pianoId) {
		this.nMatricola = nMatricola;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataNascita = dataNascita;
		this.pianoId = pianoId;
	}
	
	public long getnMatricola() {
		return nMatricola;
	}
	public void setnMatricola(long nMatricola) {
		this.nMatricola = nMatricola;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public long getPianoId() {
		return pianoId;
	}

	public void setPianoId(long pianoId) {
		this.pianoId = pianoId;
	}
	
}
	
	