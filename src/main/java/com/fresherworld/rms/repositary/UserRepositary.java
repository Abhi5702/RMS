package com.fresherworld.rms.repositary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fresherworld.rms.mapper.UserRowMapper;
import com.fresherworld.rms.model.Student;
import com.fresherworld.rms.model.UpdateUserRequest;
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
	
	
	public User createUser(User user) {
		System.out.println("user to be ceated "+user);
		String sql = "INSERT INTO users (first_name, last_name, user_name, email, phone_number, address, age) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		 		jdbcTemplate.update(sql,
				user.getFirstName(),
				user.getLastName(),
				user.getUserName(),
				user.getEmail(),
				user.getPhoneNo(),
				user.getAddress(),
				user.getAge()
				
				);
		
		return user;
	}
	
	public int updateUser(UpdateUserRequest userReq) {
		
		String username = userReq.getUserName();
		String sql = "SELECT COUNT(*) FROM users WHERE user_name = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, username);
	    if(count>0) {
	    	String updateQry  = "update users set first_name = ?,last_name =?,email = ?,phone_number=?,address=? where user_name = ?";
	    	return jdbcTemplate.update(updateQry, userReq.getFirstName(), userReq.getLastName(),userReq.getEmail(),userReq.getPhoneNo(),userReq.getAddress(),userReq.getUserName());
	    }else {
	    	return 0;
	    }
		
		
		
	}
	public int createStudent(Student s) {
		String sql = "insert into student values (?,?)";
		return jdbcTemplate.update(
			    "insert into student(roll_no,name) values (?,?)",
			    s.getRollNo(), s.getName()
			);
		
		
	}
	public User createUser() {
		System.out.println("create user is getting called");
		return null;
		
	}
	
	public User findbylastname(String lastname) {
		String sql = " select user_id,first_name,last_name,user_name,email,phone_number,address,age from users  WHERE last_name = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new UserRowMapper(), lastname);
		}catch(EmptyResultDataAccessException e ) {
			return null;
		}
		
		
	}
	
	public int deleteUserByUsername(String username) {
	    String sql = "DELETE FROM users WHERE user_name = ?";
	    return jdbcTemplate.update(sql, username); 
	    // returns number of rows deleted (0 if none found)
	}

	
	

}
