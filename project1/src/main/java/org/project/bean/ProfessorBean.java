package org.project.bean;

import java.util.ArrayList;
import java.util.Date;

public class ProfessorBean {
	private String nome;
	private String cognome;
	private Long matricola;



	private String email;
	private ArrayList<Long> esami;
	private Date dataNascita;

	public ProfessorBean(){}

	public ProfessorBean(String nome, String cognome, Long matricola, String email, ArrayList<Long> esami, Date dataNascita) {
		this.nome=nome;
		this.cognome= cognome;
		this.matricola= matricola;
		this.email= email;
		this.esami= new ArrayList<>();
		this.dataNascita= dataNascita;
	}

	public String getNome() {
		return this.nome;
	}
	public String getCognome() {
		return this.cognome;
	}
	public Long getMatricola() {
		return this.matricola;
	}
	public String getEmail() {
		return this.email;
	}
	public ArrayList<Long> getEsami(){
		return this.esami;
	}
	public Date getDataNascita() {
		return this.dataNascita;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setMatricola(Long matricola) {
		this.matricola = matricola;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEsami(ArrayList<Long> esami) {
		this.esami = esami;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
}
