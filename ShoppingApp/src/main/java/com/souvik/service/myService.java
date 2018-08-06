package com.souvik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souvik.dto.AppOrders;
import com.souvik.dto.BillData;
import com.souvik.dto.ChartData;
import com.souvik.dto.Product;
import com.souvik.dto.ProductCategory;
import com.souvik.repository.myRepository;

@Service
public class myService {
	@Autowired
	myRepository repo;

	public int addnewcategory(String id, String name) {
		// TODO Auto-generated method stub
		return repo.addnewcategory(id,name);
	}

	public ProductCategory modifycategorysearch(String id) {
		// TODO Auto-generated method stub
	
		return repo.modifycategorysearch(id);
	}

	public int updatecategory(String id, String name) {
		// TODO Auto-generated method stub
		return repo.updatecategory(id,name);
	}

	public int deletecategory(String id) {
		// TODO Auto-generated method stub
		return repo.deletecategory(id);
	}

	public List<ProductCategory> searchcategory() {
		// TODO Auto-generated method stub
		return repo.searchcategory();
	}

	public int addnproduct(String id, String name, String category, int price) {
		// TODO Auto-generated method stub
		return repo.addnproduct(id,name,category,price);
	}

	public Product findproductadmin(String id) {
		// TODO Auto-generated method stub
		return repo.findproductadmin(id);
	}

	public int updateproductadmin(String id, String name, String category, int price) {
		// TODO Auto-generated method stub
		return repo.updateproductadmin(id,name,category,price);
	}

	public int deleteproductadmin(int id) {
		// TODO Auto-generated method stub
		return repo.deleteproductadmin(id);
	}

	public List<Product> fetchproducts() {
		// TODO Auto-generated method stub
		return repo.fetchproducts();
	}

	public int checkcredentials(String id, String password) {
		// TODO Auto-generated method stub
		return repo.checkcredentials(id,password);
	}

	public int buyproducts(String uname, String products, String total) {
		// TODO Auto-generated method stub
		return repo.buyproducts(uname,products,total);
	}

	public List<AppOrders> fetchcustomerdata() {
		// TODO Auto-generated method stub
		return repo.fetchcustomerdata();
	}

	public List<BillData> fetchbillingdata() {
		// TODO Auto-generated method stub
		return repo.fetchbillingdata();
	}

	public List<ChartData> fetchchartdata() {
		// TODO Auto-generated method stub
		return repo.fetchchartdata();
	}


}
