
package org.project.controller;


//import org.json.JSONObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.project.bean.ResultStateBean;
import org.project.bean.StudentBean;
import org.project.dao.UniversityBookletDao;
import org.project.util.UtilityController.ResponseState;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UniversityBookletController extends HttpServlet
{
    private static final long serialVersionUID = -3047939190531613496L;

    public UniversityBookletController() {
        super();
    }

    @Override
    protected void doPost( HttpServletRequest request,
                           HttpServletResponse response ) throws ServletException, IOException
    {
        UniversityBookletDao ubd = new UniversityBookletDao();
        String stud = request.getParameter( "student" );
        long studentID = Long.parseLong( request.getParameter( "student" ) );
        ResultStateBean result = ubd.getUniversityBooklet( studentID );
        RequestDispatcher rd = null;

        if (result.getState() == ResponseState.SUCCESS.getCode()) {
            rd = request.getRequestDispatcher( "/WEB-INF/view/universityBooklet.jsp" );

            //request.setAttribute( "examsPlan", new JSONObject( result.getResultSet() ) );
        } else {
            // Empty body.
        }

        rd.forward( request, response );
    }
}