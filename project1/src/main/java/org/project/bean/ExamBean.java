package org.project.bean;

public class ExamBean {
	private long id;
	private String nome;
	private int crediti;
	private String descrizione;
	private long matricolaProfessor;
	
	public ExamBean (long id, String nome, int crediti, String descrizione, long matricolaProfessor) {
		this.id = id;
		this.nome = nome;
		this.crediti = crediti;
		this.descrizione = descrizione;
		this.matricolaProfessor = matricolaProfessor;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCrediti() {
		return crediti;
	}
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public long getMatricolaProfessor() {
		return matricolaProfessor;
	}
	public void setMatricolaProfessor(long matricolaProfessor) {
		this.matricolaProfessor = matricolaProfessor;
	}
}
