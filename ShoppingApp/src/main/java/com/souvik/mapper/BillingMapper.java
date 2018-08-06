package com.souvik.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.souvik.dto.BillData;

public class BillingMapper implements RowMapper<BillData> {
	
	@Override
	public BillData mapRow(ResultSet rs,int Rownum) throws SQLException{
		
		BillData apporders = new BillData();
		apporders.setTotalPrice(Integer.parseInt(""+rs.getInt(1)));
		apporders.setDate(rs.getString("ORDERDATE"));
		return apporders;
	}

}
