package org.project.service;

// import org.project.bean.SearchBean;
import org.project.bean.ServiceBean;
import org.project.dao.SearchDao;

import java.sql.SQLException;
import java.util.List;

public class SearchService {
	
	public List<ServiceBean> searchKeyWordService(String keyword){
		SearchDao searchDao = new SearchDao() ;
		List<ServiceBean> result = null;
		try {
			result = searchDao.searchKeyWord(keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
