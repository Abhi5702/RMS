package com.fresherworld.rms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	@GetMapping("/find-by-user-id")
	public User getuserbyuserId(@RequestParam("user_id") String userId) {
		return userRepositary.findUserByUserId(userId);
	}
	
	@GetMapping("/find-by-email-id")
	public User getuserbyemailid(@RequestParam String email) {
		return userRepositary.finduserbyEmailid(email);
	}
	

}
