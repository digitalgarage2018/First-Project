package org.project.bean;

public class ExamBean {
	private long idExam;
	private String name;
	private int credits;
	private String description;
	private String professor;

	public ExamBean() {

	}

	public ExamBean(long idExam, String name, int credits, String description) {
		this.idExam = idExam;
		this.name = name;
		this.credits = credits;
		this.description = description;
	}

	public long getIdExam() {
		return idExam;
	}

	public void setIdExam(long idExam) {
		this.idExam = idExam;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}
}
