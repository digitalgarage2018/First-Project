package org.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.bean.LoginBean;
import org.project.dao.LoginDao;

 
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public LoginController() {
		super();
	}
 
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isLogged	= false;
		LoginBean loginBean = new LoginBean(username,password, isLogged);
		LoginDao loginDao = new LoginDao() ;
		RequestDispatcher rd = null;
		//System.out.println("valore prima: " +result);
		
		String result = loginDao.authenticateUser(loginBean);
		HttpSession session=request.getSession();
		System.out.println("valore ritornato: " +result);
		try {
			if (result.equals("success")) {
				rd = request.getRequestDispatcher("/index.jsp");
				LoginBean user = new LoginBean(username, password, isLogged);
	
				//HttpSession session=request.getSession();  
				session.setAttribute("user", user.getUsername());
				//request.setAttribute("user", user);
				
				//response.sendRedirect("/WEB-INF/view/success.jsp");
			} else {
				session.invalidate();
	            request.setAttribute("errorMessage", "Invalid user or password");
	            rd = request.getRequestDispatcher("/login.jsp");
				//rd = request.getRequestDispatcher("/WEB-INF/view/error.jsp");
			}
		} 
		finally{
		rd.forward(request, response);
		}
	}
 
}
