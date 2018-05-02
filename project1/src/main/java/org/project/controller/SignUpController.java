/*
 ============================================================================
 Name        : SignUpController.java
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		/*
		 * creazione user
		 */
		UserBean userBean = new UserBean(username, email, password);
		UserDao userDao = new UserDao();
		//id gestito da auto increment
		userDao.createUser(userBean);
		
		/*
		 * creazione wallet
		 */
		WalletBean walletBean = new WalletBean(userBean.getId(),1000);
		WalletDao walletDao = new WalletDao();
		//id gestito da auto increment
		walletDao.createWallet(walletBean);
		
		/*
		 * associazione del wallet allo user
		 */
		userBean.setWallet(walletBean);
		
		/*
		 * Invio della mail di conferma all'indirizzo specificato
		 */
		new EmailSMTP().sendMail(email);
		
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/index.jsp");
		
		// attributo per attivare un alert lato view... migliorabile
		request.setAttribute("authenticated", true);
		
		rd.forward(request, response);
	}
 
}
