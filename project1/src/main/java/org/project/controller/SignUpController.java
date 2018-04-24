package org.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.bean.LoginBean;
import org.project.bean.UserBean;
import org.project.dao.LoginDao;
import org.project.dao.UserDao;

 
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public SignUpController() {
		super();
	}
 
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserBean userBean = new UserBean(username,password);
		UserDao userDao = new UserDao();
		
		userDao.createUser(userBean);
		
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/WEB-INF/view/success.jsp");
		
		rd.forward(request, response);
	}
 
}
