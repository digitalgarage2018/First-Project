package org.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.bean.UserBean;
import org.project.bean.WalletBean;
import org.project.dao.UserDao;
import org.project.dao.WalletDao;

 
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public LoginController() {
		super();
	}
 
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao userDao = new UserDao();
		UserBean loggedUser = userDao.authenticateUser(username, password);
		RequestDispatcher rd = null;
		if(loggedUser != null) {
			rd = request.getRequestDispatcher("/WEB-INF/view/map.jsp");
			
			/*
			 * recupero del wallet 
			 */
			WalletDao walletDao = new WalletDao();
			WalletBean wallet = walletDao.readByIdUser(loggedUser.getId());
			loggedUser.setWallet(wallet);
			
			request.setAttribute("user", loggedUser);
			request.setAttribute("wallet", wallet);
			
		}
		else {
			rd = request.getRequestDispatcher("/WEB-INF/view/error.jsp");
		}
		
		rd.forward(request, response);
		
	}
 
}
