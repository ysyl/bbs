package com.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bbs.entity.Broad;
import com.bbs.entity.Topic;
import com.bbs.service.ForumService;
import com.bbs.service.UserService;

@RestController
@RequestMapping("forum")
public class ForumController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ForumService forumService;
	
	@GetMapping("broad/all")
	public List<Broad> getAllBroad() {
		return forumService.getAllBroad();
	}
	
	@GetMapping("topic/broad/{broadId}")
	public List<Topic> showTopicByBroadId(@PathVariable("broadId") int broadId) {
		return forumService.getAllTopicByBroadId(broadId);
	}
	
	@GetMapping("topic/user/{userId}")
	public List<Topic> showTopicByUserId(@PathVariable("userId") long userId,
			@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		return forumService.getPagedTopicsByUserId(userId, pageNo, pageSize);
	}
	
}
