package org.project.dao;

import static org.project.util.DBController.connectDB;
import static org.project.util.DBController.disconnectDB;
import static org.project.util.DBController.rs;
import static org.project.util.DBController.stmt;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.project.bean.HouseBean;

public class HouseDao {
	
	private static final String SELECT = "SELECT * FROM houses WHERE 1=1";
	

	public List<HouseBean> find(Map<String, String> parameters){
		List<HouseBean> houses = new ArrayList<>();
		
		String minPrice, maxPrice, minSize, maxSize, minLatitude, maxLatitude, minLongitude, maxLongitude;
		
		System.out.println(parameters);
		
		minPrice = parameters.get("minPrice");
		maxPrice = parameters.get("maxPrice");
		minSize = parameters.get("minSize");
		maxSize = parameters.get("maxSize");
		minLatitude = parameters.get("minLatitude");
		maxLatitude = parameters.get("maxLatitude");
		minLongitude = parameters.get("minLongitude");
		maxLongitude = parameters.get("maxLongitude");
		
		StringBuilder query = new StringBuilder();

		query.append(SELECT);
		
		if(minPrice != null && maxPrice != null && minPrice != "" && maxPrice != "") {
			query.append(" and");
			query.append(" Price>" + minPrice);
			query.append(" and");
			query.append(" Price<" + maxPrice);
		}
		
		if(minSize != null && maxSize != null && minSize != "" && maxSize != "") {
			query.append(" and");
			query.append(" Size>" + minSize);
			query.append(" and");
			query.append(" Size<" + maxSize);
		}
		
		if(minLatitude != null && maxLatitude != null && minLatitude != "" && maxLatitude != "") {
			query.append(" and");
			query.append(" Latitude>" + minLatitude);
			query.append(" and");
			query.append(" Latitude<" + maxLatitude);			
		}
		
		if(minLongitude != null && maxLongitude != null && minLongitude != "" && maxLongitude != "") {
			query.append(" and");
			query.append(" Longitude>" + minLongitude);
			query.append(" and");
			query.append(" Longitude<" + maxLongitude);						
		}
		
		System.out.println(query.toString());
		
		try {

			if(connectDB(query.toString())) {
				rs = stmt.executeQuery();

				while(rs.next()){
					HouseBean house = new HouseBean();
					house.setIndirizzo(rs.getString("Address"));
					house.setCosto(rs.getDouble("Price"));
					
					houses.add(house);
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			disconnectDB();
		}
		
		return houses;
	}

}
