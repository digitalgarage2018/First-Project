package org.project.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.project.util.DBController.*;
import org.project.bean.ServiceBean;


public class SearchDao {

    private static final String SEARCH_BY_KEYWORD = "select * from SERVICES where sr_name LIKE ?";

    public  List<ServiceBean> searchKeyWord(String keyword) throws SQLException {

        List<ServiceBean> serviceList = new ArrayList<>();

        try {
            if(connectDB(SEARCH_BY_KEYWORD)) {
                stmt.setString(1, '%' + keyword + '%');
                rs = stmt.executeQuery();

                while (rs.next()) {
                    ServiceBean service = new ServiceBean();
                    service.setSr_name(rs.getString("sr_name"));
                    service.setSr_type(rs.getString("sr_type"));
                    service.setSr_description(rs.getString("sr_description"));
                    service.setSr_price(rs.getInt("sr_price"));
                    service.setSr_time(rs.getInt("sr_time"));
                    service.setSr_wellness_center(rs.getString("sr_wellness_center"));
                    service.setSr_serviceID(rs.getInt("sr_serviceID"));
                    service.setSr_image(rs.getString("sr_image"));
                    serviceList.add(service);
                }
            }
            else {
                return null;
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            disconnectDB();
        }

        return serviceList;
    }

}
