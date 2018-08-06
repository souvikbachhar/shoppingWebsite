package com.souvik.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.souvik.dto.Product;

public class ProductMapper  implements RowMapper<Product>{
	@Override
	public Product mapRow(ResultSet rs,int Rownum) throws SQLException{
		
		Product product = new Product();
		product.setProductId(rs.getString("PRODUCTID"));
		
		product.setProductName((rs.getString("PRODUCTNAME")));
		//System.out.println(product.getProductName());
		product.setProductCategory((rs.getString("PRODUCTCATEGORY")));
		product.setProductPrice(Integer.parseInt((rs.getString("PRODUCTPRICE"))));
		//System.out.println(product.toString());
		return product;
	}
}
