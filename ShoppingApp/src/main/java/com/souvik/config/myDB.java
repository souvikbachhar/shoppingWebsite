package com.souvik.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class myDB {
	@Bean("myOracleDs")
	public DataSource myOracleDs() throws SQLException{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setUsername("topgear");
		ds.setPassword("topgear");
		ds.setDriverClassName("oracle.jdbc.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1522/xe");
		return ds;
	}
}
