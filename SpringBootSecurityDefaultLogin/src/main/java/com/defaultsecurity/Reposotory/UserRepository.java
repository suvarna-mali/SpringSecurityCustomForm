package com.defaultsecurity.Reposotory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defaultsecurity.Entity.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String>{
	
	 public UserModel findByUsername(String username);	

}
