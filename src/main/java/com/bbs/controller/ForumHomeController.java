package com.bbs.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.mapper.UserMapper;

@Controller
@RequestMapping("index")
public class ForumHomeController {
	private static final  Logger  LOGGER = Logger.getLogger(ForumHomeController.class);
	
	@Autowired
	UserMapper userMapper;

	public static void main(String... args) {
		LOGGER.error("test");
		
		if (!LOGGER.isDebugEnabled()) {
			LOGGER.debug("debug");			
		}
	}
	
	@GetMapping("/allForums")
	public String indexAllForums() {
		userMapper.lockUserByUsername("joy");
		return "index";
	}
	
	@GetMapping("/forum/{forumId}")
	public String showForum(@PathVariable("forumId") long forumId) {
		return "index";
	}
}
