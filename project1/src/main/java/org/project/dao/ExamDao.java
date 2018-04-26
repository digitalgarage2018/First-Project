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
    private static final String SELECT_BY_EXAM = "SELECT * FROM Exam";

    public ResultStateBean getElencoEsami() {

        ResultStateBean result = new ResultStateBean("", "", ResponseState.NOCHANGE.getCode());
        ArrayList<ExamBean> res = new ArrayList<ExamBean>();
        try {
            if (connectDB(SELECT_BY_EXAM)) {
                rs = stmt.executeQuery();
            }
            while (rs.next()) {
                ExamBean e = new ExamBean();
                e.setId(rs.getInt("Id"));
                e.setNome(rs.getString("Name"));
                e.setCrediti(rs.getInt("Crediti"));
                e.setDescrizione(rs.getString("Description"));
                e.setMatricolaProfessor(rs.getLong("BNProfessor"));
                res.add(e);
            }
            result.setResultSet(res);
            result.setErrorState(ResponseState.SUCCESS.getCode());
            result.setMessage("while success");
            result.setResult("OK");

        } catch (SQLException e) {
            result.setErrorState(ResponseState.FAILURE.getCode());
            result.setMessage("Error while try catch");
            result.setResult("KO");
            throw new RuntimeException(e);
        } finally {
            disconnectDB();
        }
        return result;
    }
}
