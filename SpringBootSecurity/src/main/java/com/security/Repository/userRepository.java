package com.security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.model.UserModel;

public interface userRepository extends JpaRepository<UserModel, String> {
 
      public UserModel findByUsername(String username);	
	
}
