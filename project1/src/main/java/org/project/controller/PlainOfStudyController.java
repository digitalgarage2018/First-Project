package org.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.project.bean.ResultStateBean;
import org.project.dao.ExamDao;
import org.project.util.UtilityController.ResponseState;

public class PlainOfStudyController extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 87296426396152806L;

    public PlainOfStudyController() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        ExamDao examDao=new ExamDao();

        RequestDispatcher rd = null;

        ResultStateBean rsb = new ResultStateBean("","",0,examDao.getAllExams());

        if(ResponseState.SUCCESS.getCode() == rsb.getState()){
            rd = request.getRequestDispatcher("/WEB-INF/view/plainOfStudy.jsp");
            request.setAttribute("allExams", new JSONObject(rsb.getResultSet()));
        } else {
            rd = request.getRequestDispatcher("/WEB-INF/view/error.jsp");
        }

        rd.forward(request, response);
    }
}
