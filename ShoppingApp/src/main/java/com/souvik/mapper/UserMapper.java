package com.souvik.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.souvik.dto.Product;
import com.souvik.dto.Users;

public class UserMapper  implements RowMapper<Users>{
	@Override
	public Users mapRow(ResultSet rs,int Rownum) throws SQLException{
		
		Users users = new Users();
		users.setUserID(rs.getString("USERID"));
		users.setUserPassword((rs.getString("PASSWORD")));
		users.setUsertype(Integer.parseInt((rs.getString("USERTYPE"))));

		
		return users;
	}
}
