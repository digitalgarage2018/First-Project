package org.project.controller;

import com.google.gson.Gson;

import org.project.bean.BuildingBean;
import org.project.dao.BuildingDao;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MarkerController extends HttpServlet {

    public MarkerController() {
        super();
    }

    public ArrayList<BuildingBean> grabPlaces() {
        return BuildingDao.getUpdatedPlacesFromDB();
    }

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        int range = Integer.parseInt(request.getParameter("myRange"));

        BuildingDao markerDao = new BuildingDao();
        ArrayList<MarkerBean> listOfPlaces = markerDao.getPlacesByRange(range);


        RequestDispatcher rd = null;

        if(listOfPlaces != null) {
            rd = request.getRequestDispatcher("/WEB-INF/view/map.jsp");

            String json = new Gson().toJson(listOfPlaces);
            request.setAttribute("places", json);
        }
        else {
            rd = request.getRequestDispatcher("/WEB-INF/view/error.jsp");
        }

        rd.forward(request, response);

    }


}
