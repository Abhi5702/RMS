package com.fresherworld.rms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	

}
