package com.saimonfill.repairhistoryapi.model.jwt;

import com.saimonfill.repairhistoryapi.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserAuthenticated implements UserDetails {

	private final Users users;

	public UserAuthenticated(Users users) {
		this.users = users;
	}

	@Override
	public String getUsername() {
		return users.getUsername();
	}

	@Override
	public String getPassword() {
		return users.getPassword();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority(users.getAuthorities()));
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