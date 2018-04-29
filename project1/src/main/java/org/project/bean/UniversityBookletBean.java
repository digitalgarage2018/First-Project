package org.project.bean;

import java.util.ArrayList;
import java.util.List;

public class UniversityBookletBean
{
    private List<ExamPlan> exams;

    public UniversityBookletBean() {
        exams = new ArrayList<>();
    }

    public void addExam( String name, String professor, int credits, int mark ) {
        addExam( new ExamPlan( name, professor, credits, mark ) );
    }

    public void addExam( ExamPlan ep ) {
        exams.add( ep );
    }

    public List<ExamPlan> getExams() {
        return exams;
    }

    public static class ExamPlan
    {
        private String name;
        private String professor;
        private int credits;
        private int mark;

        public ExamPlan( String name, String professor, int credits, int mark )
        {
            this.name      = name;
            this.professor = professor;
            this.credits   = credits;
            this.mark      = mark;
        }

        public String getName() {
            return name;
        }

        public void setName( String name ) {
            this.name = name;
        }

        public String getProfessor() {
            return professor;
        }

        public void setProfessor( String professor ) {
            this.professor = professor;
        }

        public int getCredits() {
            return credits;
        }

        public void setCredits( int credits ) {
            this.credits = credits;
        }

        public int getMark() {
            return mark;
        }

        public void setMark( int mark ) {
            this.mark = mark;
        }
    }
}
