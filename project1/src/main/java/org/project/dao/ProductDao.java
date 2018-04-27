package org.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.project.bean.Product;

import static org.project.util.DBController.*;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ProductDao {	

   // private DBController dataSource;

    
  //  public ProductDao(DBController dataSource) {
  //      this.dataSource = dataSource;
  //  }

    public static List<Product> list() throws SQLException {
        List<Product> products = new ArrayList<Product>();

        try {
        		
             if(connectDB("SELECT id, name, description, price FROM product")) {
           
             rs = stmt.executeQuery();
         {
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                products.add(product);
            }
        }
             }

       
    }catch (SQLException e) {
		throw new RuntimeException(e);
	
    }finally {
    	disconnectDB();
    }
        return products;
	
	

}
    
}
