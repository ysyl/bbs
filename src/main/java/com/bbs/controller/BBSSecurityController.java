package com.bbs.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bbs.entity.User;
import com.bbs.exception.UnAuthenticatedException;
import com.bbs.exception.UsernameIsExistsException;
import com.bbs.msg.Message;
import com.bbs.service.UserService;

@RestController
@RequestMapping("authentication")
public class BBSSecurityController {

	@Autowired
	UserService userService;
	
	
	@PostMapping("register")
	public Message register(User user) throws UsernameIsExistsException {
		userService.register(user);
		return 	new Message("登录成功");	
	}
	
	@GetMapping("required")
	public void redirect() throws UnAuthenticatedException {
		throw new UnAuthenticatedException();
	}
	
	
	
	@GetMapping("testLogin")
	public void redirect2(HttpServletRequest req, HttpServletResponse res) throws IOException {
		RequestCache requestCache = new HttpSessionRequestCache();
		RedirectStrategy rs = new DefaultRedirectStrategy();
		rs.sendRedirect(req, res, "/login.jsp");

	}
	
}
