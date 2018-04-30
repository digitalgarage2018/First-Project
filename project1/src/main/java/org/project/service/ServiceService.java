package org.project.service;

import java.sql.SQLException;
import java.util.List;

import org.project.bean.ServiceBean;
import org.project.dao.ServiceDao;

public class ServiceService {
	
	public List<ServiceBean> getServiceService() throws SQLException {
		ServiceDao serviceDao = new ServiceDao();
		List<ServiceBean> result = serviceDao.getServices();
		return result;
		
	}

}
