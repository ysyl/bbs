package com.bbs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.bbs.entity.Permission;
import com.bbs.entity.Role;
import com.bbs.entity.User;
import com.bbs.entity.UserPrincipal;
import com.bbs.exception.UserIsNotFoundException;
import com.bbs.exception.UsernameIsExistsException;
import com.bbs.mapper.PermissionMapper;
import com.bbs.mapper.RoleMapper;
import com.bbs.mapper.UserMapper;
import com.bbs.vo.VUser;

import javax.annotation.PostConstruct;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	RoleMapper roleMapper;
	
	@Autowired
	PermissionMapper permissionMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	
	
	public void checkUsername(String username) throws UsernameIsExistsException {
		int userNum = userMapper.countByUsername(username);
		if  (userNum > 0) {
			throw new UsernameIsExistsException();
		}
	}
	
	@PreAuthorize("#user.id == 0 and "
			+ "hasAuthority('create_user')")
	public void register(@Validated User user) throws UsernameIsExistsException {
		checkUsername(user.getUsername());
		encryptPassword(user);
		userMapper.insert(user);
	}
	
	public void encryptPassword(User user) {
			String password = user.getPassword();
			password = passwordEncoder.encode(password);
			user.setPassword(password);
	}
	
	@PreAuthorize("#user.id == authentication.principal.id or "
			+ "hasAuthority('edit_any_user')")
	public void update(User user) {
		userMapper.updateByPrimaryKey(user);
	}
	
//	@PreAuthorize("hasAuthority('view_any_user')")
	public UserPrincipal getUserByUsername(String username) throws UserIsNotFoundException {
		UserPrincipal up = userMapper.selectByUsername(username);
		System.out.println(up.getUsername());
		if ( up == null ) {
			throw new UserIsNotFoundException("该用户不存在");
		}
		return up;
	}
	
	@PreAuthorize("hasAuthority('view_any_user')")
	public User getUserById(long id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	@PreAuthorize("hasAuthority('edit_any_user')")
	public void lockUser(String username) {
		userMapper.lockUserByUsername(username);
	}
	
	@PreAuthorize("hasAuthority('edit_any_user')")
	public void unlockUser(String username) {
		userMapper.unlockUserByUsername(username);
	}
	
	@PreAuthorize("hasAuthority('view_any_user')")
	public List<UserPrincipal> getAllUsers() {
		return userMapper.selectAllUser();
	}
	
	@PreAuthorize("hasAuthority('view_any_user')")
	public List<User> queryAllUserByUsername(String username) {
		return userMapper.selectAllUserLikeUsername(username);
	}
	
	public VUser getVUser(long userId) {
		return userMapper.selectVUser(userId, null);
	}
	
	public VUser getVUser(String username) {
		return userMapper.selectVUser(null, username);
	}
	
	public List<Role> getRoles(long userId) {
		return roleMapper.selectAll(userId);
	}
	
	public List<Permission> getPermissions(long userId) {
		return (List<Permission>) permissionMapper.selectAll(userId, null);
	}

	public List<Permission> getPermissions(Integer roleId) {
		return (List<Permission>) permissionMapper.selectAll(null, roleId);
	}
	
	public List<GrantedAuthority> getAuthority(long userId) {
		return (List<GrantedAuthority>) permissionMapper.selectAll(userId, null);
	}
	
}
