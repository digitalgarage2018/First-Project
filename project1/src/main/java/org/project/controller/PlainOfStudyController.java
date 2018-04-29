package org.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.bean.StudentBean;
import org.project.dao.ExamDao;
import org.project.dao.LoginDao;
import org.project.dao.RegisterDao;
import org.project.dao.UniversityBookletDao;

public class PlainOfStudyController extends HttpServlet {

    private static final long serialVersionUID = 87296426396152806L;
    
    private static Long studyPlanId;
    

    public PlainOfStudyController() {
        super();
    }
    
    @Override
    public void init() throws ServletException
    {
        super.init();
        
        studyPlanId = UniversityBookletDao.getMaxStudyPlanId() + 1;
    }

    protected void doPost( HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {

        ExamDao examDao=new ExamDao();

        RequestDispatcher rd = null;
        
        long spId;
        synchronized (studyPlanId) {
            spId = studyPlanId++;
        }
        
        Long studentID = (Long) request.getSession().getAttribute( "studentID" );
        new RegisterDao().insertStudyPlanId( studentID, spId );
        
        String[] exams = request.getParameterValues( "exam" );
        for (String exam : exams) {
            examDao.saveExams( spId, Long.parseLong( exam ) );
        }

        //ResultStateBean rsb = new ResultStateBean("","",0,examDao.getAllExams());

        /*if(ResponseState.SUCCESS.getCode() == rsb.getState()){
            rd = request.getRequestDispatcher("/WEB-INF/view/plainOfStudy.jsp");
            request.setAttribute("allExams", new JSONObject(rsb.getResultSet()));
        } else {
            rd = request.getRequestDispatcher("/WEB-INF/view/error.jsp");
        }*/
        
        LoginDao loginDao = new LoginDao();
        
        StudentBean student = loginDao.getStudentInfo( studentID );
        rd = request.getRequestDispatcher("/WEB-INF/view/studentWelcome.jsp");
        request.setAttribute( "student", student );
        rd.forward(request, response);
    }
}
