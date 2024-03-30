package com.Telusko.Security.SecureApp;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class UserDetailsImpl implements UserDetails {

	private List<GrantedAuthority> authorities;
	private User user;

	public UserDetailsImpl(User user)
	{
		this.user=user;
		this.authorities=Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//return Collections.singleton(new SimpleGrantedAuthority("USER"));
		return authorities;
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
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
		return true;
	}

}
