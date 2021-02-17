package com.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

	User user;
	
	public MyUserDetails(User user){
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<String> listofauth = user.getAuthorities();
		List <GrantedAuthority> auth = new ArrayList<>();
		
		for(String str: listofauth) {
			auth.add(new SimpleGrantedAuthority(str));
		}
		return auth;
	}

	@Override
	public String getPassword() {
	
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
	
		return this.user.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
	
		
		return this.user.getActive()==1;
		
	}


}
