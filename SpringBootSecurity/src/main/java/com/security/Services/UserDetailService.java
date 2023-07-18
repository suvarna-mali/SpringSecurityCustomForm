package com.security.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.Repository.userRepository;
import com.security.model.CustomUserDetail;
import com.security.model.UserModel;

@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	private userRepository userepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserModel user= this.userepository.findByUsername(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("NO USER");
		}
		
		return new CustomUserDetail(user);
	}

}
