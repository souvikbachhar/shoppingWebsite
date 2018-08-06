package com.souvik.dto;

public class Product {
	private String ProductId;
	private String ProductCategory;
	private String ProductName;
	private int ProductPrice;
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getProductCategory() {
		return ProductCategory;
	}
	public void setProductCategory(String productCategory) {
		ProductCategory = productCategory;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(int productPrice) {
		ProductPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", ProductCategory=" + ProductCategory + ", ProductName="
				+ ProductName + ", ProductPrice=" + ProductPrice + "]";
	}
}
