package org.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.bean.SignUpBean;
import org.project.dao.SignUpDao;


public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public SignUpController() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email	= request.getParameter("email");
		String name		= request.getParameter("name");
		String surname	= request.getParameter("surname");
		String born_date	= request.getParameter("born_date");
		String born_place	= request.getParameter("born_place");
		SignUpBean signUpBean = new SignUpBean(username,password,email,name,surname,born_date,born_place);
		SignUpDao signUpDao = new SignUpDao() ;
		RequestDispatcher rd = null;
		//System.out.println("valore prima: " +result);
		
		String result = signUpDao.registerUser(signUpBean);
		System.out.println("valore ritornato: " +result);
		if (result.equals("success")) {
			rd = request.getRequestDispatcher("index.jsp");
			SignUpBean user = new SignUpBean(username,password,email,name,surname,born_date,born_place);
			request.setAttribute("user", user);
			
			//open session for user
			HttpSession session=request.getSession();  
			session.setAttribute("user", user.getUsername());
			//
			
		} else if(result.equals("errorDB")){
			//session.invalidate();
            request.setAttribute("errorMessage", "Errore connessione database. Riprova più tardi");
            rd = request.getRequestDispatcher("/sign_up.jsp");
		}
		
		else {
			rd = request.getRequestDispatcher("/WEB-INF/view/signup_error.jsp");
		}
		rd.forward(request, response);
	}
}
