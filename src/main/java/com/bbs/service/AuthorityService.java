package com.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.bbs.mapper.PermissionMapper;
import com.bbs.mapper.UserMapper;

@Service
public class AuthorityService {

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	PermissionMapper permissionMapper;
	
	public boolean checkPermission(long userId, String permName) {
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> perms = (List<GrantedAuthority>) permissionMapper.selectAll(userId);
		
		for (GrantedAuthority perm: perms) {
			if (perm.getAuthority().equals(permName))
				return true;
		}
		return false;
	}
}
