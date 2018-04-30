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
import org.project.service.ServiceService;

public class ServiceController extends HttpServlet{

    public ServiceController() {
    	super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	ServiceService serviceService = new ServiceService();
            List<ServiceBean> serviceList = serviceService.getServiceService();
            if(serviceList != null){
            	request.setAttribute("services", serviceList); // Will be available as ${products} in JSP
            }
            else {
            	request.setAttribute("errorMessage", "Errore connessione database. Riprova più tardi");
            }
            request.getRequestDispatcher("/service_list.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Cannot obtain services from DB", e);
        }
    }
	
    
    /*
	private List<ServiceBean> serviceList;
	private String searchServices;
	
    public String getSearchServices() {
		return searchServices;
	}
    
	public void setSearchServices(String searchServices) {
		this.searchServices = searchServices;
	}

    
public void loadServices() {
		
		System.out.println("ENTRO LOAD");
        serviceList.clear();

        try {            
            if (searchServices != null && searchServices.trim().length() > 0) {
                // search for services by name
                serviceList = ServiceDao.searchService(searchServices);                
            }
            else {
                // get all services from database
                serviceList = ServiceDao.getServices();
            }            

        } catch (Exception exc) {
            // send this to server logs
          //  logger.log(Level.SEVERE, "Error loading services", exc);

            // add error message
          
        }
        finally {
            // reset the search info
            searchServices = null;
        }
    }*/

}
