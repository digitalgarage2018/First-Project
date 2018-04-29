package org.project.bean;

import java.util.*;

public class PlanOfStudyBean {
	private ArrayList<ExamBean> exams;
	private long idPlainOfStudy;

	public PlanOfStudyBean(long idPlainOfStudy, ArrayList<ExamBean> exams) {
		this.idPlainOfStudy = idPlainOfStudy;
		this.exams = exams;
	}

	public ArrayList<ExamBean> getExams() {
		return exams;
	}

	public void setExams(ArrayList<ExamBean> exams) {
		this.exams = exams;
	}

	public long getIdPlainOfStudy() {
		return idPlainOfStudy;
	}

	public void setIdPlainOfStudy(long idPlainOfStudy) {
		this.idPlainOfStudy = idPlainOfStudy;
	}
}
