package com.security.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.security.model.UserModel;

@Service
public class UserService {
	
	List<UserModel> list=new ArrayList<UserModel>();

	public UserService() {
		super();
		// TODO Auto-generated constructor stub
		list.add(new UserModel("abc", "1234", "abc@gmail.com"));
		list.add(new UserModel("xyz", "567", "xyz@gmail.com"));
		list.add(new UserModel("pqr", "4321", "pqr@gmail.com"));
	}
	
	//get all user
	
	public List<UserModel> getAllUser()
	{
		return this.list;
	}

	//get signle user
	public UserModel getUser(String username)
	{
		return this.list.stream().filter((user)-> user.getUsername().equals(username)).findAny().orElse(null);
	}
	
	// add user
	public UserModel addUser(UserModel user)
	{
		
		this.list.add(user);
		return user;
	
	
	}
}
