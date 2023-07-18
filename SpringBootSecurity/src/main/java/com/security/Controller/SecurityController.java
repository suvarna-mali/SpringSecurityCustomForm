package com.security.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.Services.UserService;
import com.security.model.UserModel;

@RestController
@RequestMapping("/users")
public class SecurityController {

	@Autowired
	public UserService userservice;
	
	@GetMapping("/getuser")
	public List<UserModel> getAllUser()
	{
		return this.userservice.getAllUser();
	}
	
	@GetMapping("/getuser/{username}")
	public UserModel getUser(@PathVariable("username") String username)
	{
		return this.userservice.getUser(username);
	}
	
	@PostMapping("/add")
	public UserModel addUser(@RequestBody UserModel user)
	{
		return this.userservice.addUser(user);
	}
	
	
}
