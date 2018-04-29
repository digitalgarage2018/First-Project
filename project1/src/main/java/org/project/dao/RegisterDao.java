package org.project.dao;

import org.project.bean.StudentBean;

import java.sql.SQLException;

import static org.project.util.DBController.*;
import static org.project.util.DBController.rs;
import static org.project.util.DBController.stmt;

public class RegisterDao {

    private final static String CHECK_STUDENT = "SELECT * FROM Student WHERE name=? AND surname=? AND personalEmail=? AND dateOfBirth=?";
    private final static String INSERT_STUDENT = "INSERT INTO Student VALUES (?, ?, ?, ?, ?, ?, 0)";
    private final static String INSERT_LOGIN = "INSERT INTO Login VALUES (?, ?, ?, ?)";
    private final static String SELECT_BADGE_NUMBER_MAX = "SELECT MAX(badgeNumber) FROM student ";


    public boolean authenticateStudent(StudentBean student) {
        boolean ret = false;
        try {
            if (connectDB(CHECK_STUDENT)) {
                stmt.setString(1, student.getName());
                stmt.setString(2, student.getSurname());
                stmt.setString(3, student.getPersonalEmail());
                stmt.setDate(4, new java.sql.Date(student.getDateOfBirth().getTime()));

                rs = stmt.executeQuery();

                if (rs.next()) {
                    ret = true;
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

    public boolean insertNewStudent(StudentBean student) {
        boolean insert = true;
        try {
            if (connectDB(INSERT_STUDENT)) {
                stmt.setLong(1, student.getBadgeNumber());
                stmt.setString(2, student.getName());
                stmt.setString(3, student.getSurname());
                stmt.setString(4, student.getPersonalEmail());
                stmt.setString(5, student.getIstitutionalEmail());
                stmt.setDate(6, new java.sql.Date(student.getDateOfBirth().getTime()));
                insert = stmt.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            disconnectDB();
        }
        return insert;
    }

    public boolean insertLogin(StudentBean student, String password) {
        boolean insert = true;
        try {
            if (connectDB(INSERT_LOGIN)) {
                stmt.setLong(1, student.getBadgeNumber());
                stmt.setString(2, student.getIstitutionalEmail());
                stmt.setString(3, password);
                stmt.setString(4,"S");
                insert = stmt.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            disconnectDB();
        }
        return insert;
    }

    public long getMaxBadgeNumber(){
        long ret = 10000;
        try{
            if (connectDB(SELECT_BADGE_NUMBER_MAX)) {
                rs = stmt.executeQuery();

                if(rs.next()){
                    ret = rs.getLong(1);
                    return ret;
                }
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            disconnectDB();
        }
        return ret;
    }

}