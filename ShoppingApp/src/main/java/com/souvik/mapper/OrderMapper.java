package com.souvik.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.souvik.dto.AppOrders;

public class OrderMapper implements RowMapper<AppOrders> {
	
	@Override
	public AppOrders mapRow(ResultSet rs,int Rownum) throws SQLException{
		
		AppOrders apporders = new AppOrders();
		apporders.setOrderUser(rs.getString("ORDERUSER"));
		apporders.setOrderID(Integer.parseInt(rs.getString("ORDERID")));
		apporders.setTotalPrice(Integer.parseInt(rs.getString("TOTALPRICE")));
		apporders.setOrderDate(rs.getString("ORDERDATE"));
		apporders.setOrderProducts(rs.getString("ORDERPRODUCTS"));
		return apporders;
	}

}
