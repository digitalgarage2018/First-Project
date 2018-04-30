package org.project.service;

import org.project.bean.LoginBean;
import org.project.dao.LoginDao;

public class LoginService {
	
	public String authenticateUserService (LoginBean loginBean){
		LoginDao loginDao = new LoginDao() ;
		String result = loginDao.authenticateUser(loginBean);
		return result;
	}
}
