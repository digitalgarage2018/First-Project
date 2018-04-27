package org.project.dao;

import org.project.bean.StudentBean;

import java.sql.SQLException;

import static org.project.util.DBController.*;
import static org.project.util.DBController.rs;
import static org.project.util.DBController.stmt;

public class RegisterDao {

    private final static String CHECK_STUDENT = "SELECT * FROM Student WHERE Name=? AND Surname=? AND Email=? AND DateOfBirth=?";
    private final static String INSERT_STUDENT = "INSERT INTO Student (?,?,?,?,?)";
    private final static String INSERT_LOGIN = "INSERT INTO Login (?,?,?,S)";

    public boolean authenticateStudent(StudentBean studente){
        boolean ret=false;
        try {
            if(connectDB(CHECK_STUDENT))
            {
                stmt.setString(1, studente.getNome());
                stmt.setString(2, studente.getCognome());
                stmt.setString(3, studente.getEmail());
                stmt.setDate(4, new java.sql.Date(studente.getDataNascita().getTime()));
                rs = stmt.executeQuery();

                if (rs.next()) {
                	ret=true;
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
