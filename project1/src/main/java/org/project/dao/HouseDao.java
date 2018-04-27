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
	private static final double[] center = {45.474687, 9.187337};
	private static final String SELECT = "SELECT * FROM house WHERE 1=1";
    private static final String RANGE =
            " and (POW ( ( 69.1 * ( longitude - " + center[1] + " ) * cos( " + center[0] + " / 57.3 ) ) , 2 ) " +
                    "+ POW( ( 69.1 * ( latitude - " + center[0] + " ) ) , 2 ) ) < ";

	public List<HouseBean> find(Map<String, String> parameters){
		List<HouseBean> houses = new ArrayList<>();
		
		String minPrice, maxPrice, minArea, maxArea, 
			/*minLatitude, maxLatitude, minLongitude, 
			maxLongitude,*/ type, city, E_class;

		String range;
		
		System.out.println(parameters);
		
		minPrice = parameters.get("minPrice");
		maxPrice = parameters.get("maxPrice");
		minArea = parameters.get("minArea");
		maxArea = parameters.get("maxArea");
		/*
		minLatitude = parameters.get("minLatitude");
		maxLatitude = parameters.get("maxLatitude");
		minLongitude = parameters.get("minLongitude");
		maxLongitude = parameters.get("maxLongitude");
		*/
		type = parameters.get("type");
		city = parameters.get("city");
		E_class = parameters.get("E_class");
		range = parameters.get("range");
		
		StringBuilder query = new StringBuilder();

		query.append(SELECT);
		
		if(minPrice != null && maxPrice != null && minPrice != "" && maxPrice != "") {
			query.append(" and");
			query.append(" price>" + minPrice);
			query.append(" and");
			query.append(" price<" + maxPrice);
		}
		
		if(minArea != null && maxArea != null && minArea != "" && maxArea != "") {
			query.append(" and");
			query.append(" area>" + minArea);
			query.append(" and");
			query.append(" area<" + maxArea);
		}
		
		/*
		if(minLatitude != null && maxLatitude != null && minLatitude != "" && maxLatitude != "") {
			query.append(" and");
			query.append(" latitude>" + minLatitude);
			query.append(" and");
			query.append(" latitude<" + maxLatitude);			
		}
		
		if(minLongitude != null && maxLongitude != null && minLongitude != "" && maxLongitude != "") {
			query.append(" and");
			query.append(" longitude>" + minLongitude);
			query.append(" and");
			query.append(" longitude<" + maxLongitude);						
		}
		*/
		
		if(type != null && type != "")
			query.append(" and type='" + type + "'");
		
		if(city != null && city != "")
			query.append(" and city='" + city + "'");

		if(E_class != null && E_class != "")
			query.append(" and E_class='" + E_class + "'");

		if(range != null && !range.equals(""))
			query.append(RANGE + range);
			
		System.out.println(query.toString());
		
		try {

			if(connectDB(query.toString())) {
				rs = stmt.executeQuery();

				while(rs.next()){
					HouseBean house = new HouseBean();
					
					house.setId(rs.getInt("id"));
					house.setName(rs.getString("name"));
					house.setAddress(rs.getString("address"));
					house.setCity(rs.getString("city"));
					house.setPrice(rs.getDouble("price"));
					house.setE_class(rs.getString("E_class").charAt(0));
					
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
