package org.project.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.bean.Product;
import org.project.bean.ServiceBean;
import org.project.dao.ProductDao;
import org.project.dao.ServiceDao;
import org.project.service.SearchService;

public class SearchController extends HttpServlet{

	public SearchController() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String keyword = request.getParameter("keyword");
			SearchService searchService = new SearchService();
			List<ServiceBean> serviceList = searchService.searchKeyWordService(keyword);
			if(serviceList != null){
				System.out.println("Ci sono servizi da mostrare");
				request.setAttribute("services", serviceList); // Will be available as ${products} in JSP
			}
			else {
				System.out.println("Non ci sono servizi corrispondenti");

				request.setAttribute("errorMessage", "Errore connessione database. Riprova più tardi");
			}
			request.getRequestDispatcher("/service_list.jsp").forward(request, response);
		} finally{
			System.out.println("bah!!!");
		}
	}

}
