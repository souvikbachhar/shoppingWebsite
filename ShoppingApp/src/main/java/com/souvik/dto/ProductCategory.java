package com.souvik.dto;

import org.springframework.context.annotation.Bean;


public class ProductCategory {
	
	private String ProductCategoryName;
	private String ProductCategoryID;
	public String getProductCategoryName() {
		return ProductCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		ProductCategoryName = productCategoryName;
	}
	public String getProductCategoryID() {
		return ProductCategoryID;
	}
	public void setProductCategoryID(String productCategoryID) {
		ProductCategoryID = productCategoryID;
	}
	
}
