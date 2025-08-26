package com.fresherworld.rms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fresherworld.rms.model.Student;
import com.fresherworld.rms.model.User;
import com.fresherworld.rms.repositary.UserRepositary;

@RestController
public class UserController {
	
	
	@Autowired
	UserRepositary userRepositary;
	
	
	@GetMapping("/find-by-user-name")
	public User getUserByUserName(@RequestParam String userName) {
		return userRepositary.findUserByUserName(userName);
	}
	
	@GetMapping("/get-test-message")
	public String getMessage() {
		return "This is sent from RMS application";
	}
	
	@GetMapping("/get-student")
	public Student getStudent() {
		Student s = new Student();
		s.setRollNo(13);
		s.setName("Parmanand");
		return s;
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		
		Student s = new Student();
		s.setRollNo(13);
		s.setName("Parmanand");
		Student s2 = new Student();
		s2.setRollNo(11);
		s2.setName("Abhinav");
		students.add(s);
		students.add(s2);
		return students;
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		users = userRepositary.getAllUsers();
		
		return users;
	}
	
	
	@GetMapping("/find-by-user-id")
	public User getuserbyuserId(@RequestParam("user_id") String userId) {
		return userRepositary.findUserByUserId(userId);
	}
	
	@GetMapping("/find-by-email-id")
	public User getuserbyemailid(@RequestParam String email) {
		return userRepositary.finduserbyEmailid(email);
	}
	 @PostMapping("/createStudent")
	    public String createUser(@RequestBody Student student) {
		 
	        // Here you would normally save user into DB (using JPA/Repository)
		 
			/*
			 * System.out.println("student name "+student.getName());
			 * System.out.println("student Roll "+student.getRollNo());
			 */
		 int result = userRepositary.createStudent(student);
		 if(result==1) {
			 return "Student created: " + student.getName() + " (" + student.getName() + ")";
		 }else {
			 return "Error while creating student";
		 }
	        
	    }
	//post mapping /createUser   
	//payload for request body User 
	 
	 
	 
	 
	 @PostMapping("/createuser")
	 public User createNewuser(@RequestBody User user) {
	 	return userRepositary.createUser(user);
	 }
	 
	 @GetMapping("/findbylastname")
	 public User getuserbylastname(@RequestParam String lastname) {
	 	return userRepositary.findbylastname(lastname);
	 }
	 
	 
	

}
