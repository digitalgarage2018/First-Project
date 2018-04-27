package org.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.bean.Product;
import org.project.dao.ProductDao;
import org.project.util.DBController;

public class ProductsServlet extends HttpServlet{
	
   // @Resource("jdbc/YourDB") // For Tomcat, define as <Resource> in context.xml and declare as <resource-ref> in web.xml.
   // private DBController dataSource;
  //  private ProductDao productDAO;
    
    public ProductsServlet() {
    	super();
    }

   // @Override
  //  public void init() {
        //productDAO = new ProductDao(dataSource);
   // }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Product> products = ProductDao.list();
            request.setAttribute("products", products); // Will be available as ${products} in JSP
            request.getRequestDispatcher("/Products.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Cannot obtain products from DB", e);
        }
    }

}
