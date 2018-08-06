package com.souvik.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.souvik.dto.ProductCategory;



public class CategoryMapper implements RowMapper<ProductCategory>{
	@Override
	public ProductCategory mapRow(ResultSet rs,int Rownum) throws SQLException{
		
		ProductCategory Pcat = new ProductCategory();
		Pcat.setProductCategoryID(rs.getString("CategoryId"));
		Pcat.setProductCategoryName((rs.getString("CategoryName")));
		return Pcat;
	}
}
