package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security.Repository.userRepository;
import com.security.model.UserModel;

@SpringBootApplication
public class SpringBootSecurityApplication implements CommandLineRunner {

	@Autowired
	private userRepository userrepository;
	
	@Autowired
	private PasswordEncoder passEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		UserModel user=new UserModel();
		user.setEmail("abc@gmail.com");
		user.setUsername("abc");
		user.setPassword(this.passEncoder.encode("1234"));
	    user.setRole("ROLE_NORMAL");
	    this.userrepository.save(user);
	    
	    UserModel user1=new UserModel();
	    user1.setEmail("xyz@gmail.com");
		user1.setUsername("xyz");
		user1.setPassword(this.passEncoder.encode("567"));
	    user1.setRole("ROLE_ADMIN");
	    this.userrepository.save(user1);
	    
	
		
	}

}
