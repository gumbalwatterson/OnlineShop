package com.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String useremail) throws UsernameNotFoundException {
	
		User user = repo.findByEmail(useremail);
	
		if(user!= null) {
		
		return new MyUserDetails(user);
		}
		
		else throw new UsernameNotFoundException("User not found");
		
	}

}
 