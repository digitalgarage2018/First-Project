package org.project.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.project.bean.ExamBean;
import org.project.bean.LoginBean;
import org.project.bean.ProfessorBean;
import org.project.bean.ResultStateBean;
import org.project.bean.StudentBean;
import org.project.dao.ExamDao;
import org.project.dao.LoginDao;
import org.project.util.UtilityController.ResponseState;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public LoginController() {
		super();
	}
 
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		LoginDao loginDao = new LoginDao();
		RequestDispatcher rd = null;
		
		ExamDao examDao = new ExamDao();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		LoginBean loginBean = new LoginBean(username,password);

		ResultStateBean resultSet = loginDao.authenticateUser(loginBean);

		LoginBean user1 = (LoginBean) resultSet.getResultSet();

	

		ProfessorBean professor = loginDao.getProfessorInfo(user1);

		if (resultSet.getState() == ResponseState.SUCCESS.getCode() && user1.getFlagType().equals("S")) {
			StudentBean student = loginDao.getStudentInfo(user1);
			if(student.getIdPlainOfStudy()==0){
				
				ArrayList<ExamBean> allExams = examDao.getAllExams();

				rd = request.getRequestDispatcher("/WEB-INF/view/plainOfStudy.jsp");
				request.getSession().setAttribute( "studentID", student.getBadgeNumber() );
				request.setAttribute("allExams", new JSONArray(allExams));
			}else {
				rd = request.getRequestDispatcher("/WEB-INF/view/studentWelcome.jsp");
				request.setAttribute("student", student);
				request.setAttribute("resultSet", resultSet);
			}
		} else if(resultSet.getState() == ResponseState.SUCCESS.getCode() && user1.getFlagType().equals("D")){
			rd = request.getRequestDispatcher("/WEB-INF/view/professorWelcome.jsp");
			ArrayList<ExamBean> allProfExams=examDao.getProfExams(professor.getBadgeNumber());
			request.setAttribute("professor", professor);
			request.setAttribute("resultSet", resultSet);
			request.setAttribute("examsList", new JSONArray(allProfExams));
			
			
		} else {
			rd = request.getRequestDispatcher("/WEB-INF/view/error.jsp");
		}
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/register.jsp");

		rd.forward(request, response);

	}
 
}
