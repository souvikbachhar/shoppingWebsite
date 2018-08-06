package com.souvik.dto;

public class AppOrders {
	private int OrderID;
	private String OrderUser;
	private String OrderProducts;
	private int TotalPrice;
	private String OrderDate;
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public String getOrderUser() {
		return OrderUser;
	}
	public void setOrderUser(String orderUser) {
		OrderUser = orderUser;
	}
	public String getOrderProducts() {
		return OrderProducts;
	}
	public void setOrderProducts(String orderProducts) {
		OrderProducts = orderProducts;
	}
	public int getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		TotalPrice = totalPrice;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	@Override
	public String toString() {
		return "AppOrders [OrderID=" + OrderID + ", OrderUser=" + OrderUser + ", OrderProducts=" + OrderProducts
				+ ", TotalPrice=" + TotalPrice + ", OrderDate=" + OrderDate + "]";
	}
}
