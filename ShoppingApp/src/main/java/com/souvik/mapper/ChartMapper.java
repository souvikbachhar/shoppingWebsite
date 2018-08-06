package com.souvik.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.souvik.dto.BillData;
import com.souvik.dto.ChartData;

public class ChartMapper implements RowMapper<ChartData>{
	
	@Override
	public ChartData mapRow(ResultSet rs,int Rownum) throws SQLException{
		
		ChartData cdata = new ChartData();
		cdata.setValue(""+rs.getInt(1));
		cdata.setLabel(rs.getString("ORDERDATE"));
		return cdata;
	}

}
