package org.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.bean.LoginBean;
import org.project.bean.ResultStateBean;
import org.project.dao.ExamDao;
import org.project.dao.LoginDao;
import org.project.util.UtilityController.ResponseState;

public class ExamController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ExamController() {
        super();
    }

    protected void doPost (HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        ExamDao examDao = new ExamDao();

        RequestDispatcher rd = null;
        //System.out.println("valore prima: " +result);

        ResultStateBean result = new ResultStateBean("","",0,null);
        result.setResultSet(examDao.getAllExams());

        System.out.println("valore ritornato: " +result.getMessage());

        if(ResponseState.SUCCESS.getCode() == result.getState()){
            rd = request.getRequestDispatcher("/WEB-INF/view/success.jsp");
            request.setAttribute("resultSet", result);
        } else {
            rd = request.getRequestDispatcher("/WEB-INF/view/error.jsp");
        }

        rd.forward(request, response);
    }
}


