package com.souvik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.souvik.dto.AppOrders;
import com.souvik.dto.BillData;
import com.souvik.dto.ChartData;
import com.souvik.dto.Product;
import com.souvik.dto.ProductCategory;
import com.souvik.service.myService;



@Controller
public class MyController {
	@Autowired
	myService service;
	
			
	@GetMapping("/addncategory")
	public  @ResponseBody int addnewcategory(@RequestParam("id") String id,@RequestParam("name") String name){
		return service.addnewcategory(id,name);
	}
	
	@GetMapping("/modifycategorysearch")
	public  @ResponseBody ProductCategory modifycategorysearch(@RequestParam("id") String id){
		return service.modifycategorysearch(id);
	}
	
	@GetMapping("/updatecategory")
	public  @ResponseBody int updatecategory(@RequestParam("id") String id,@RequestParam("name") String name){
		return service.updatecategory(id,name);
	}
	
	@GetMapping("/deletecategoryadmin")
	public  @ResponseBody int deletecategory(@RequestParam("id") String id){
		return service.deletecategory(id);
	}
	
	@GetMapping("/searchcategory")
	public  @ResponseBody List<ProductCategory> searchcategory()	{
		return service.searchcategory();
	}
	
	
	@GetMapping("/addnproduct")
	public  @ResponseBody int addnproduct(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("category") String category,@RequestParam("price") int price){
	return service.addnproduct(id,name,category,price);
	
	}
	
	@GetMapping("/findproductadmin")
	public  @ResponseBody Product findproductadmin(@RequestParam("id") String id){
		return service.findproductadmin(id);
	}
	
	@GetMapping("/updateproductadmin")
	public  @ResponseBody int updateproductadmin(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("category") String category,@RequestParam("price") int price){
	return service.updateproductadmin(id,name,category,price);
	
	}
	
	
	@GetMapping("/deleteproductadmin")
	public  @ResponseBody int deleteproductadmin(@RequestParam("id") int id){
		return service.deleteproductadmin(id);
	}
	
	@GetMapping("/fetchproducts")
	public  @ResponseBody List<Product> fetchproducts()	{
		return service.fetchproducts();
	}
	
	
	@GetMapping("/checkcredentials")
	public  @ResponseBody int checkcredentials(@RequestParam("id") String id,@RequestParam("pwd") String password){
		return service.checkcredentials(id,password);
	}
	
	
	@GetMapping("/buyproducts")
	public  @ResponseBody int buyproducts(@RequestParam("id") String uname,@RequestParam("Products") String Products,@RequestParam("total") String total){
		
		return service.buyproducts(uname,Products,total);
	}
	
	@GetMapping("/fetchcustomerdata")
	public  @ResponseBody List<AppOrders> fetchcustomerdata(){
		
		return service.fetchcustomerdata();
	}
	
	@GetMapping("/fetchbillingdata")
	public  @ResponseBody List<BillData> fetchbillingdata(){
		
		return service.fetchbillingdata();
	}
	
	@GetMapping("/fetchchartdata")
	public  @ResponseBody List<ChartData> fetchchartdata(){
		
		return service.fetchchartdata();
	}
}
