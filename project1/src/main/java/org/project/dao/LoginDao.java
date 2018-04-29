package org.project.dao;

import org.project.bean.LoginBean;
import org.project.bean.ProfessorBean;
import org.project.bean.ResultStateBean;
import org.project.bean.StudentBean;
import org.project.util.UtilityController.ResponseState;

import static org.project.util.DBController.*;

import java.sql.SQLException;


public class LoginDao {

	//private static final String SELECT_USER = "SELECT * FROM Login WHERE (badgeNumber=? OR istitutionalEmail=?) AND password=?";
	private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM login WHERE istitutionalEmail=? AND password=?";

	private static final String SELECT_STUDENT_INFO = "SELECT * FROM student INNER JOIN login ON login.badgeNumber=student.badgeNumber WHERE student.badgeNumber=? ";

	private static final String SELECT_DOCENT_INFO = "SELECT * FROM professor INNER JOIN login ON login.badgeNumber=professor.badgeNumber WHERE professor.badgeNumber=? ";


	public ResultStateBean authenticateUser(LoginBean loginBean)
	{
		ResultStateBean ret = new ResultStateBean("Null","Null",ResponseState.NOCHANGE.getCode(), loginBean);

		try {

			if(connectDB(SELECT_USER_BY_USERNAME)) {
				stmt.setString(1, loginBean.getUsername());
				stmt.setString(2,loginBean.getPassword());
				rs = stmt.executeQuery();

				if (rs.next()) {
					if(loginBean.getUsername().equals(rs.getString("istitutionalEmail"))	 && loginBean.getPassword().equals(rs.getString("password"))) {
						ret.setState(ResponseState.SUCCESS.getCode()); ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
						ret.setMessage("Utente autenticato");
						loginBean.setBadgeNumber(rs.getString("badgeNumber"));
						loginBean.setFlagType(rs.getString("flagType"));
						ret.setResultSet(loginBean);
						ret.setResult("OK");
					}else{
						ret.setState(ResponseState.FAILURE.getCode());
						ret.setMessage("Email o Passoword Errate");
						ret.setResult("KO");
					}
					disconnectDB();
					return ret;
				} else {
					disconnectDB();
					ret.setState(ResponseState.FAILURE.getCode());
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

	public StudentBean getStudentInfo(LoginBean loginBean){
		StudentBean student = new StudentBean();
		try {

			if(connectDB(SELECT_STUDENT_INFO)) {
				stmt.setString(1, loginBean.getBadgeNumber());
				rs = stmt.executeQuery();
				if(rs.next()){

					student.setName(rs.getString("name"));
					student.setSurname(rs.getString("surname"));
					student.setPersonalEmail(rs.getString("personalEmail"));
					student.setDateOfBirth(rs.getDate("dateOfBirth"));
					student.setBadgeNumber(rs.getLong("badgeNumber"));
				}
				return student;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			disconnectDB();
		}
		return student;
	}

	public ProfessorBean getProfessorInfo(LoginBean loginBean){
		ProfessorBean professor = new ProfessorBean();
		try {

			if(connectDB(SELECT_DOCENT_INFO)) {
				stmt.setString(1, loginBean.getBadgeNumber());
				rs = stmt.executeQuery();
				if(rs.next()){

					professor.setName(rs.getString("name"));
					professor.setSurname(rs.getString("surname"));
					professor.setIstitutionalEmail(rs.getString("istitutionalEmail"));
					professor.setDateOfBirth(rs.getDate("dateOfBirth"));
					professor.setBadgeNumber(rs.getLong("badgeNumber"));
				}
				return professor;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			disconnectDB();
		}
		return professor;
	}


}
