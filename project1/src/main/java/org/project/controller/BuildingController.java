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
import java.util.HashMap;
import java.util.Map;

public class BuildingController extends HttpServlet {

    public BuildingController() {
        super();
    }

    public ArrayList<BuildingBean> grabPlaces() {
        return BuildingDao.getUpdatedPlacesFromDB();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BuildingDao buildingDao = new BuildingDao();

        String choice = req.getParameter("choice");

        if(choice.equals("filter")) {

            String minPrice = req.getParameter("minPrice");
            String maxPrice = req.getParameter("maxPrice");
            String minArea = req.getParameter("minArea");
            String maxArea = req.getParameter("maxArea");
			/*
			String minLatitude = req.getParameter("minLatitude");
			String maxLatitude = req.getParameter("maxLatitude");
			String minLongitude = req.getParameter("minLongitude");
			String maxLongitude = req.getParameter("maxLongitude");
			*/
            String type = req.getParameter("type");
            String city = req.getParameter("city");
            String E_class = req.getParameter("E_class");
            String range = req.getParameter("myRange");

            Map<String, String> parameters = new HashMap<>();

            parameters.put("minPrice", minPrice);
            parameters.put("maxPrice", maxPrice);
            parameters.put("minArea", minArea);
            parameters.put("maxArea", maxArea);
		/*
		parameters.put("minLatitude", minLatitude);
		parameters.put("maxLatitude", maxLatitude);
		parameters.put("minLongitude", minLongitude);
		parameters.put("maxLongitude", maxLongitude);
		*/
            parameters.put("type", type);
            parameters.put("city", city);
            parameters.put("E_class", E_class);
            parameters.put("range", range);

            ArrayList<BuildingBean> houses;

            houses = buildingDao.find(parameters);



            RequestDispatcher rd = null;

            if(houses != null) {
                rd = req.getRequestDispatcher("/WEB-INF/view/map.jsp");

                String json_house = new Gson().toJson(houses);
                req.setAttribute("places", json_house);
            } else {
                rd = req.getRequestDispatcher("/WEB-INF/view/error.jsp");
            }

            rd.forward(req, resp);

        } else if (choice.equals("Range")) {
            int range = Integer.parseInt(req.getParameter("myRange"));
            ArrayList<BuildingBean> listOfPlaces = buildingDao.getPlacesByRange(range);

            RequestDispatcher rd = null;

            if(listOfPlaces != null) {
                rd = req.getRequestDispatcher("/WEB-INF/view/map.jsp");

                String json = new Gson().toJson(listOfPlaces);
                req.setAttribute("places", json);
            }
            else {
                rd = req.getRequestDispatcher("/WEB-INF/view/error.jsp");
            }

            rd.forward(req, resp);
        }
    }
}

