package com.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.entity.User;
import com.bbs.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	public void register(User user) {
		userMapper.insert(user);
	}
	
	public void update(User user) {
		userMapper.updateByPrimaryKey(user);
	}
	
	public User getUserByUsername(String username) {
		return userMapper.selectByUsername(username);
	}
	
	public User getUserById(long id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	public void lockUser(String username) {
		userMapper.lockUserByUsername(username);
	}
	
	public void unlockUser(String username) {
		userMapper.unlockUserByUsername(username);
	}
	
	public List<User> getAllUsers() {
		return userMapper.selectAllUser();
	}
	
	public List<User> queryAllUserByUsername(String username) {
		return userMapper.selectAllUserLikeUsername(username);
	}
}
