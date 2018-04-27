package org.project.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.bean.HouseBean;
import org.project.dao.HouseDao;

public class HouseController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HouseDao houseDao = new HouseDao();
		
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
		
		List<HouseBean> houses;
		
		houses = houseDao.find(parameters);
		
		req.setAttribute("houses", houses);
		
		RequestDispatcher rd = null;
		
		rd = req.getRequestDispatcher("/WEB-INF/view/houses.jsp");
		
		rd.forward(req, resp);
	}
}
