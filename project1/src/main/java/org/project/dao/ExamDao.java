package org.project.dao;

import static org.project.util.DBController.connectDB;
import static org.project.util.DBController.disconnectDB;
import static org.project.util.DBController.rs;
import static org.project.util.DBController.stmt;

import java.sql.SQLException;
import java.util.ArrayList;

import org.project.bean.ExamBean;
import org.project.bean.ResultStateBean;
import org.project.util.UtilityController.ResponseState;

public class ExamDao {
    private static final String SELECT_BY_EXAM = "SELECT exam.idExam AS iExam, exam.name AS eName, credits, description, professor.name AS pName, surname FROM exam INNER JOIN professor ON professor.idExam = exam.idExam";

    public ArrayList<ExamBean> getAllExams() {

        ResultStateBean result = new ResultStateBean("", "", ResponseState.NOCHANGE.getCode(), null);
        ArrayList<ExamBean> res = new ArrayList<ExamBean>();
        try {
            if (connectDB(SELECT_BY_EXAM)) {
                rs = stmt.executeQuery();
            }
            while (rs.next()) {
                ExamBean e = new ExamBean();
                e.setIdExam(rs.getInt("iExam"));
                e.setName(rs.getString("eName"));
                e.setCredits(rs.getInt("credits"));
                e.setDescription(rs.getString("description"));
                e.setProfessor( rs.getString( "pName" ) + " " + rs.getString( "surname" ) );
                res.add(e);
            }
            /*result.setResultSet(res);
            result.setState(ResponseState.SUCCESS.getCode());
            result.setMessage("while success");
            result.setResult("OK");*/

        } catch (SQLException e) {
            /*result.setState(ResponseState.FAILURE.getCode());
            result.setMessage("Error while try catch");
            result.setResult("KO");*/
            throw new RuntimeException(e);
        } finally {
            disconnectDB();
        }
        return res;
    }
}
