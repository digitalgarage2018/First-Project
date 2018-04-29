package org.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.bean.ResultStateBean;
import org.project.dao.ExamDao;
import org.project.util.UtilityController.ResponseState;

public class PlanController {

		private static final long serialVersionUID = 1L;
	 
		public PlanController() {
			super();
		}
	 
		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
	 
			ExamDao examDao=new ExamDao();

			RequestDispatcher rd = null;

			ResultStateBean rsb=examDao.getElencoEsami();
			 if(ResponseState.SUCCESS.getCode() == rsb.getErrorState()){
		            rd = request.getRequestDispatcher("/WEB-INF/view/selectExams.jsp");
		            request.setAttribute("resultSet", rsb);
		        } else {
		            rd = request.getRequestDispatcher("/WEB-INF/view/error.jsp");
		        }

		        rd.forward(request, response);
		    }

	}


