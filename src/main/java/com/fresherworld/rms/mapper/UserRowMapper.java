package com.fresherworld.rms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fresherworld.rms.model.User;

public class UserRowMapper  implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		  User user = new User();
          user.setUserId(rs.getString("user_id"));
          user.setUserName(rs.getString("user_name"));
          user.setFirstName(rs.getString("first_name"));
          user.setLastName(rs.getString("last_name"));
          
          return user;
	}

}
