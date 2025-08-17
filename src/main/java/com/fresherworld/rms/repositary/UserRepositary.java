package com.fresherworld.rms.repositary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fresherworld.rms.mapper.UserRowMapper;
import com.fresherworld.rms.model.User;

@Repository
public class UserRepositary {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public User findUserByUserName(String userName) {
		
		 String sql = " select user_id,first_name,last_name,user_name,email,phone_number,address,age from users  WHERE user_name = ?";
         try {
             return jdbcTemplate.queryForObject(sql, new UserRowMapper(), userName);
         } catch (EmptyResultDataAccessException e) {
             return null; // User not found
         }
		
	}
	
	
	public User findUserByUserId (String userId) {
		
		 String sql = " select user_id,first_name,last_name,user_name,email,phone_number,address,age from users  WHERE user_id = ?";
		 try {
             return jdbcTemplate.queryForObject(sql, new UserRowMapper(), userId);
         } catch (EmptyResultDataAccessException e) {
             return null; // User not found
         }
		
	}
	
	public User finduserbyEmailid (String email) {
		String sql = " select user_id,first_name,last_name,user_name,email,phone_number,address,age from users  WHERE email = ?";
		 try {
            return jdbcTemplate.queryForObject(sql, new UserRowMapper(), email);
        } catch (EmptyResultDataAccessException e) {
            return null; // User not found
        }
	}
	
	public List<User> getAllUsers () {
		
		 String sql = " select user_id,first_name,last_name,user_name,email,phone_number,address,age from users ";
		 try {
            return jdbcTemplate.query(sql,new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null; // User not found
        }
		
	}

}
