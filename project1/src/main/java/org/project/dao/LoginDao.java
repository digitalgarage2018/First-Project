package org.project.dao;

import org.project.bean.LoginBean;
import org.project.bean.ResultStateBean;
import org.project.util.UtilityController.ResponseState;

import static org.project.util.DBController.*;

import java.sql.SQLException;


public class LoginDao {

	private static final String SELECT_USER = "SELECT * FROM Login WHERE (NMatricola=? OR Email=?) AND Password=?";
	private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM Login WHERE Email=?";

    /*
	public String authenticateUser(LoginBean loginBean)
	{
		String ret="";
		try {


			if(connectDB(SELECT_USER_BY_USERNAME)) {
				//stmt.setString(1, loginBean.getnMatricola());
				//stmt.setString(2, loginBean.getEmail());
				//stmt.setString(3, loginBean.getPassword());
				stmt.setString(1, loginBean.getUsername());

				rs = stmt.executeQuery();

				if (rs.next()) {
					System.out.println("risultato : " + rs);
					//if((loginBean.getnMatricola().equals(rs.getString("NMatricola")) || loginBean.getEmail().equals(rs.getString("Email")))
					if(loginBean.getUsername().equals(rs.getString("Email"))	 && loginBean.getPassword().equals(rs.getString("Password"))) {
						ret= "success"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
					}else{
						ret= "Failure";
					}
					disconnectDB();
					return ret;
				} else {
					disconnectDB();
					return "failure";
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			disconnectDB();
		}
		return "failure";
	}*/

	public ResultStateBean authenticateUser(LoginBean loginBean)
	{
		ResultStateBean ret = new ResultStateBean("Null","Null",ResponseState.NOCHANGE.getCode());

		try {

			if(connectDB(SELECT_USER_BY_USERNAME)) {
				stmt.setString(1, loginBean.getUsername());
				rs = stmt.executeQuery();

				if (rs.next()) {
					if(loginBean.getUsername().equals(rs.getString("Email"))	 && loginBean.getPassword().equals(rs.getString("Password"))) {
						ret.setErrorState(ResponseState.SUCCESS.getCode()); ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
						ret.setMessage("Utente autenticato");
						ret.setResult("OK");
					}else{
						ret.setErrorState(ResponseState.FAILURE.getCode());
						ret.setMessage("Email o Passoword Errate");
						ret.setResult("KO");
					}
					disconnectDB();
					return ret;
				} else {
					disconnectDB();
					ret.setErrorState(ResponseState.FAILURE.getCode());
					ret.setMessage("Email non registrata");
					ret.setResult("KO");
					return ret;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			disconnectDB();
		}
		return ret;
	}


}
