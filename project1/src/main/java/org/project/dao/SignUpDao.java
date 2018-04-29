package org.project.dao;

import org.project.bean.SignUpBean;
import static org.project.util.DBController.*;

import java.sql.SQLException;

public class SignUpDao {
	
	private static final String INSERT_USER = "insert into USERS (s_username,s_pword,s_email,s_name,s_surname,s_born_date,s_born_place) values (?,?,?,?,?,?,?);";



	public String registerUser(SignUpBean signUpBean)
	{
		System.out.println("entro in registerUser");
		try {

			if(connectDB(INSERT_USER)) {
				stmt.setString(1, signUpBean.getUsername());
				stmt.setString(2, signUpBean.getPassword());
				stmt.setString(3, signUpBean.getEmail());
				stmt.setString(4, signUpBean.getName());
				stmt.setString(5, signUpBean.getSurname());
				stmt.setString(6, signUpBean.getBorn_date());
				stmt.setString(7, signUpBean.getBorn_place());
				stmt.execute();
				return "success";
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			disconnectDB();
		}
		return "errorDB";
	}
}
