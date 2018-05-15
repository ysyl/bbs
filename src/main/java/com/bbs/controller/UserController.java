package com.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbs.entity.User;
import com.bbs.exception.UsernameIsExistsException;
import com.bbs.mapper.UserMapper;
import com.bbs.msg.ExceptionMsg;
import com.bbs.service.UserService;
import com.bbs.vo.VUser;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("{userId}")
	@JsonView(User.SimpleUser.class)
	public User getUserById(@PathVariable("userId") long userId) {
		return userService.getUserById(userId);
	}
	
	@PostMapping("")
	public BindingResult register(@Validated @RequestBody User user, BindingResult br) {
		userService.register(user);
		return br;
	}
	
	@PutMapping("{userId}")
	public void putUser(@PathVariable("userId") long userId, @RequestBody User user) {
		userMapper.updateByPrimaryKey(user);
	}
	
	@ExceptionHandler(UsernameIsExistsException.class)
	public ExceptionMsg handler(UsernameIsExistsException err) {
		ExceptionMsg eMsg = new ExceptionMsg(err);
		return eMsg;
	}
}
