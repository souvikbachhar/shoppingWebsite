package com.souvik.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.souvik.dto.AppOrders;
import com.souvik.dto.BillData;
import com.souvik.dto.ChartData;
import com.souvik.dto.Product;
import com.souvik.dto.ProductCategory;
import com.souvik.dto.Users;
import com.souvik.mapper.BillingMapper;
import com.souvik.mapper.CategoryMapper;
import com.souvik.mapper.ChartMapper;
import com.souvik.mapper.DistinctCategoryMapper;
import com.souvik.mapper.OrderMapper;
import com.souvik.mapper.ProductMapper;
import com.souvik.mapper.UserMapper;

@Repository
public class myRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	
	
	@Autowired
	@Qualifier("myOracleDs")
	DataSource myDs;
	
	public int addnewcategory(String id, String name){
		try{
		jdbcTemplate.setDataSource(myDs);
		jdbcTemplate.update("insert into shoppingcategory values(?,?)",new Object[]{id,name});
		}
		catch(Exception e){
			return 0;
		}
		return 1;
	}

	public ProductCategory modifycategorysearch(String id) {
		
		try{
			jdbcTemplate.setDataSource(myDs);
		    ProductCategory p=jdbcTemplate.queryForObject("select * from shoppingcategory where CATEGORYID=?",new Object[]{id},new CategoryMapper());
		   
		    return p;
			}
			catch(Exception e){
				 System.out.println(e);
				 
				return null;
			}
	
	}

	public int updatecategory(String id, String name) {
		
		try{
			jdbcTemplate.setDataSource(myDs);
			jdbcTemplate.update("update SHOPPINGPRODUCTS set PRODUCTCATEGORY=? where PRODUCTCATEGORY=(select CATEGORYNAME from shoppingcategory where CATEGORYID=?)",new Object[]{name,id});
			
			jdbcTemplate.update("update shoppingcategory set CATEGORYNAME=? where CATEGORYID=?",new Object[]{name,id});
			
			}
			catch(Exception e){
				System.out.println(e);
				
				return 0;
			}
			return 1;
	}

	public int deletecategory(String id) {
		// TODO Auto-generated method stub
		try{
		jdbcTemplate.setDataSource(myDs);

		jdbcTemplate.update("delete SHOPPINGPRODUCTS where PRODUCTCATEGORY=?",new Object[]{id});
		
		jdbcTemplate.update("delete shoppingcategory where CATEGORYID=?",new Object[]{id});

		}
		catch(Exception e){
			System.out.println(e);
			
			return 0;
		}
		return 1;
	}

	public List<ProductCategory> searchcategory() {
		// TODO Auto-generated method stub
		jdbcTemplate.setDataSource(myDs);
		
		return jdbcTemplate.query("SELECT CATEGORYNAME FROM shoppingcategory",new DistinctCategoryMapper());
	}

	public int addnproduct(String id, String name, String category, int price) {
		// TODO Auto-generated method stub
		try{
		jdbcTemplate.setDataSource(myDs);
		jdbcTemplate.update("insert into SHOPPINGPRODUCTS values(?,?,?,?)",new Object[]{id,category,name,price});
		}
		catch(Exception e){
			return 0;
		}
		return 1;
	}

	public Product findproductadmin(String id) {
		// TODO Auto-generated method stub
		try{
			jdbcTemplate.setDataSource(myDs);
		    Product p=jdbcTemplate.queryForObject("select * from SHOPPINGPRODUCTS where PRODUCTID=?",new Object[]{id},new ProductMapper());
		   
		    return p;
			}
			catch(Exception e){
				 System.out.println(e);
				 
				return null;
			}
	
	}

	public int updateproductadmin(String id, String name, String category, int price) {
		// TODO Auto-generated method stub
		try{
			jdbcTemplate.setDataSource(myDs);
			jdbcTemplate.update("update SHOPPINGPRODUCTS set PRODUCTNAME=?,PRODUCTCATEGORY=?,PRODUCTPRICE=? where PRODUCTID=?",new Object[]{name,category,price,id});
			
			}
			catch(Exception e){
				System.out.println(e);
				
				return 0;
			}
			return 1;
	}

	public int deleteproductadmin(int id) {
		// TODO Auto-generated method stub
		try{
			jdbcTemplate.setDataSource(myDs);

			jdbcTemplate.update("delete SHOPPINGPRODUCTS where PRODUCTID=?",new Object[]{id});
			
			}
			catch(Exception e){
				System.out.println(e);
				
				return 0;
			}
			return 1;
	}

	public List<Product> fetchproducts() {
		// TODO Auto-generated method stub
		jdbcTemplate.setDataSource(myDs);
		
		return jdbcTemplate.query("SELECT * FROM SHOPPINGPRODUCTS",new ProductMapper());

	}

	public int checkcredentials(String id,String password) {
		// TODO Auto-generated method stub
		try{
			jdbcTemplate.setDataSource(myDs);

			Users u	=jdbcTemplate.queryForObject("select * from shopusers where USERID=? and PASSWORD=?",new Object[]{id,password},new UserMapper());
			  if(u.getUsertype()==0)
			  {
				  return 0;
			  }
			  else
			  {
				  return 1;
			  }
			}
			catch(Exception e){
				System.out.println(e);
				
				return 2;
			}
			
	}

	public int buyproducts(String uname, String products, String total) {
		// TODO Auto-generated method stub
		try{
			jdbcTemplate.setDataSource(myDs);
			jdbcTemplate.update("insert into SHOPCARTORDERS values((select count(*) from shopcartorders)+1,?,?,?,(select sysdate from dual))",new Object[]{uname,products,total});
			}
			catch(Exception e){
				System.out.println(e);
				return 0;
			}
			return 1;
	}

	public List<AppOrders> fetchcustomerdata() {
		// TODO Auto-generated method stub
		jdbcTemplate.setDataSource(myDs);
		return jdbcTemplate.query("SELECT * FROM SHOPCARTORDERS order by ORDERID",new OrderMapper());
	}

	public List<BillData> fetchbillingdata() {
		// TODO Auto-generated method stub
		jdbcTemplate.setDataSource(myDs);
		return jdbcTemplate.query("select sum(TOTALPRICE) as Total,ORDERDATE from SHOPCARTORDERS group by ORDERDATE",new BillingMapper());
	}

	public List<ChartData> fetchchartdata() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select sum(TOTALPRICE) as Total,ORDERDATE from SHOPCARTORDERS group by ORDERDATE",new ChartMapper());
		
	}

	
}
