package com.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bbs.entity.User;
import com.bbs.entity.UserPrincipal;
import com.bbs.exception.UserIsNotFoundException;

@Service
public class BbsUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		UserPrincipal user;
		try {
			user = userService.getUserByUsername(username);
		} catch (UserIsNotFoundException e) {
			// TODO Auto-generated catch block
			throw new UsernameNotFoundException(username);
		}
		
		List<GrantedAuthority> perms = userService.getAuthority(user.getId());
		
		user.getAuthorities();
		return user;
	}

}
