
package org.project.dao;

import static org.project.util.DBController.conn;
import static org.project.util.DBController.connectDB;
import static org.project.util.DBController.disconnectDB;
import static org.project.util.DBController.stmt;
import static org.project.util.DBController.rs;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.project.bean.ResultStateBean;
import org.project.bean.UniversityBookletBean;
import org.project.util.UtilityController.ResponseState;

public class UniversityBookletDao
{
    private static final String UNIVERSITY_BOOKLET_STATEMENT = "SELECT idExam, mark FROM plainofstudy WHERE idPlainOfStudy = ?";
    private static final String EXAM_STATEMENT = "SELECT exam.name AS eName, credits, badgeNumber, professor.name AS pName, surname FROM exam INNER JOIN professor ON professor.idExam = exam.idExam WHERE exam.idExam = ?";
    //private static final String PROFESSOR_STATEMENT = "SELECT name, surname FROM professor WHERE badgeNu = ?";
    private static final String STUDY_PLAN_ID = "SELECT MAX(idPlainOfStudy) AS maxID FROM plainofstudy";
    
    public UniversityBookletDao() {
        // Empty body.
    }
    
    public static long getMaxStudyPlanId()
    {
        long studyPlanID = 0;
        try {
            if (connectDB( STUDY_PLAN_ID )) {
                rs = stmt.executeQuery();
                if (rs.next()) {
                    studyPlanID = rs.getLong( "maxID" );
                }
            }
        } catch ( SQLException e ) {
            throw new RuntimeException( e );
        } finally {
            disconnectDB();
        }
        
        return studyPlanID;
    }

    public ResultStateBean getUniversityBooklet( Long studyPlanID )
    {
        ResultStateBean ret = new ResultStateBean( null, null, ResponseState.NOCHANGE.getCode(), null );
        UniversityBookletBean pds = new UniversityBookletBean();

        try {
            if (connectDB( UNIVERSITY_BOOKLET_STATEMENT )) {
                stmt.setString( 1, "" + studyPlanID );
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    // Get the study plan information.
                    long examID = rs.getLong( "idExam" );
                    int mark    = rs.getInt( "mark" );

                    // Retrieve the exam information.
                    stmt = conn.prepareStatement( EXAM_STATEMENT );
                    stmt.setString( 1, "" + examID );
                    ResultSet examRS = stmt.executeQuery();
                    if (examRS.next()) {
                        String name      = examRS.getString( "eName" );
                        int credits      = examRS.getInt( "credits" );
                        //long professorID = examRS.getLong( "professorBadgeNumber" );
                        
                        String profName    = examRS.getString( "pName" );
                        String profSurname = examRS.getString( "surname" );
                        String professor   = profName + " " + profSurname;

                        pds.addExam( name, professor, credits, mark );
                        
                        
                        // Retrieve the name of the professor.
                        /*stmt = conn.prepareStatement( PROFESSOR_STATEMENT );
                        stmt.setString( 1, "" + professorID );
                        ResultSet professorRS = stmt.executeQuery();
                        if (professorRS.next()) {
                            String profName    = professorRS.getString( "Name" );
                            String profSurname = professorRS.getString( "Surname" );
                            String professor   = profName + " " + profSurname;

                            pds.addExam( name, professor, credits, mark );
                        } else {
                            setErrorResult( ret, "Professor '" + professorID + "' not found." );
                        }*/
                    } else {
                        setErrorResult( ret, "Exam '" + examID + "' not found." );
                    }
                }
            }
        } catch ( SQLException e ) {
            throw new RuntimeException( e );
        } finally {
            disconnectDB();
        }

        ret.setState( ResponseState.SUCCESS.getCode() );
        ret.setMessage( "Utente autenticato" );
        ret.setResult( "OK" );

        ret.setResultSet( pds );

        return ret;
    }

    private void setErrorResult( ResultStateBean ret, String error )
    {
        disconnectDB();
        ret.setState( ResponseState.FAILURE.getCode() );
        ret.setMessage( error );
        ret.setResult( "KO" );
    }
}