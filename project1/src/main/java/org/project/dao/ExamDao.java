package org.project.dao;

import static org.project.util.DBController.connectDB;
import static org.project.util.DBController.disconnectDB;
import static org.project.util.DBController.rs;
import static org.project.util.DBController.stmt;

import java.util.ArrayList;

import org.project.bean.ExamBean;

public class ExamDao {
	private static final String SELECT_BY_EXAM = "SELECT * FROM Exam";

	public ArrayList <ExamBean> getElencoEsami(){
		
		ArrayList <ExamBean> res = new ArrayList <ExamBean>();
		try {
			if(connectDB(SELECT_BY_EXAM)) {
				rs = stmt.executeQuery();
			}	while(rs.next()){
				ExamBean e = new ExamBean();
				e.setId( rs.getInt("Id") );
				e.setNome( rs.getString("Nome") );
				e.setCrediti(rs.getInt("Crediti"));
				
				
				
				
				
				res.add(e);
				disconnectDB();}
			catch (SQLException e) {
		e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
		}
}
