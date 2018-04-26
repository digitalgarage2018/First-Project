/*
 ============================================================================
 Name        : SignInController.java
 Author      : Alessio Onori
 Version     : 1.0
 Copyright   : Your copyright notice
 Description : controller per la business logic della registrazione
 ============================================================================
 */

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

 
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public SignUpController() {
		super();
	}
 
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		/*
		 * creazione user
		 */
		UserBean userBean = new UserBean(username,password);
		UserDao userDao = new UserDao();
		//id gestito da auto increment
		userDao.createUser(userBean);
		
		/*
		 * creazione wallet
		 */
		WalletBean walletBean = new WalletBean(userBean.getId(),1000);
		WalletDao walletDao = new WalletDao();
		walletDao.createWallet(walletBean);
		userBean.setWallet(walletBean);
		
		
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/index.jsp");
		
		rd.forward(request, response);
	}
 
}
