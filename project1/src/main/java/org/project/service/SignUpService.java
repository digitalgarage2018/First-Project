package org.project.service;

import org.project.bean.SignUpBean;
import org.project.dao.SignUpDao;

public class SignUpService {
	
	
	public String registrationUserService(SignUpBean signUpBean) {
		SignUpDao signUpDao = new SignUpDao();
		String result = signUpDao.registerUser(signUpBean);
		return result;
		
		
	}

}
