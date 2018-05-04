package com.bbs.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.mapper.UserMapper;
import com.bbs.service.UserService;

@Controller
@RequestMapping("index")
public class ForumHomeController {
	private static final  Logger  LOGGER = Logger.getLogger("com.bbs.service.UserServiceTest");
	
	@Autowired
	UserService userService;
	
	public static void main(String... args) {
		LOGGER.error("测试logger");
		
		if (!LOGGER.isDebugEnabled()) {
			LOGGER.debug("debug");			
		}
	}
	
	@GetMapping("/allForums")
	public String indexAllForums() {
		userService.lockUser("瑜亮");
		return "index";
	}
	
	@GetMapping("/forum/{forumId}")
	public String showForum(@PathVariable("forumId") long forumId) {
		return "index";
	}
}
