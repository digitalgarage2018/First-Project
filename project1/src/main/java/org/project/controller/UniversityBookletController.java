
package org.project.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.project.bean.ResultStateBean;
import org.project.dao.UniversityBookletDao;
import org.project.util.UtilityController.ResponseState;

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
        long studentID = Long.parseLong( request.getParameter( "studyPlanID" ) );
        ResultStateBean result = ubd.getUniversityBooklet( studentID );
        RequestDispatcher rd = null;

        if (result.getState() == ResponseState.SUCCESS.getCode()) {
            rd = request.getRequestDispatcher( "/WEB-INF/view/universityBooklet.jsp" );
            request.setAttribute( "examsPlan", new JSONObject( result.getResultSet() ) );
        } else {
            // Empty body.
        }

        rd.forward( request, response );
    }
}