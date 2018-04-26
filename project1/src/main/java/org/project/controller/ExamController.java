package org.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.bean.LoginBean;
import org.project.dao.LoginDao;

public class ExamController {

	private static final long serialVersionUID = 1L;
	
	public ExamController() {
		super();
	}
	
	protected void doPost (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		int crediti = request.;
		
		LoginBean loginBean = new LoginBean(nome,password);
		LoginDao loginDao = new LoginDao() ;
		RequestDispatcher rd = null;
		//System.out.println("valore prima: " +result);
		
		String result = loginDao.authenticateUser(loginBean);
		System.out.println("valore ritornato: " +result);
		
		String nome = request.getParameter("nome");
	}
	
}
