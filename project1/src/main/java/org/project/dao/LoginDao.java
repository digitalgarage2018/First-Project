package org.project.dao;

import org.project.bean.LoginBean;
import org.project.bean.ProfessorBean;
import org.project.bean.ResultStateBean;
import org.project.bean.StudentBean;
import org.project.util.UtilityController.ResponseState;

import static org.project.util.DBController.*;

import java.sql.SQLException;
import java.util.ArrayList;


public class LoginDao {

	//private static final String SELECT_USER = "SELECT * FROM Login WHERE (NMatricola=? OR Email=?) AND Password=?";
	private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM Login WHERE Email=? AND Password=?";

	private static final String SELECT_STUDENT_INFO = "SELECT * FROM Student " +
			"INNER JOIN Login ON Login.NMatricola=Student.BadgeNumber" +
			"WHERE Tipo=? AND BdageNumber=?";
	private static final String SELECT_DOCENT_INFO = "SELECT * FROM Docent " +
			"INNER JOIN Login ON Login.NMatricola=Docent.BadgeNumber" +
			"WHERE Tipo=? AND BdageNumber=?";


	public ResultStateBean authenticateUser(LoginBean loginBean)
	{
		ResultStateBean ret = new ResultStateBean("Null","Null",ResponseState.NOCHANGE.getCode(), loginBean);

		try {

			if(connectDB(SELECT_USER_BY_USERNAME)) {
				stmt.setString(1, loginBean.getUsername());
				rs = stmt.executeQuery();

				if (rs.next()) {
					if(loginBean.getUsername().equals(rs.getString("Email"))	 && loginBean.getPassword().equals(rs.getString("Password"))) {
						ret.setErrorState(ResponseState.SUCCESS.getCode()); ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
						ret.setMessage("Utente autenticato");
						loginBean.setnMatricola(rs.getString("BadgeNumber"));
						loginBean.setType(rs.getString("Type"));
						ret.setResultSet(loginBean);
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

	public StudentBean getStudentInfo(LoginBean loginBean){
		StudentBean studente = new StudentBean();
		try {

			if(connectDB(SELECT_STUDENT_INFO)) {
				stmt.setString(1, loginBean.getType());
				stmt.setString(2, loginBean.getnMatricola());
				rs = stmt.executeQuery();
				if(rs.next()){

					studente.setNome(rs.getString("Name"));
					studente.setCognome(rs.getString("Surname"));
					studente.setEmail(rs.getString("PersonalEmail"));
					studente.setDataNascita(rs.getDate("DateOfBirth"));
					studente.setnMatricola(rs.getLong("BadgeNumber"));
					studente.setPianoId(rs.getInt("PianoID"));
				}
				return studente;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			disconnectDB();
		}
		return studente;
	}

	public ProfessorBean getProfessorInfo(LoginBean loginBean){
		ProfessorBean professor = new ProfessorBean();
		ResultStateBean ret = new ResultStateBean("Null","Null",ResponseState.NOCHANGE.getCode(), loginBean);

		try {

			if(connectDB(SELECT_DOCENT_INFO)) {
				stmt.setString(1, loginBean.getType());
				stmt.setString(2, loginBean.getnMatricola());
				rs = stmt.executeQuery();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			disconnectDB();
		}
		return professor;
	}


}
