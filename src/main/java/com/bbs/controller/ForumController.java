package com.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bbs.entity.Broad;
import com.bbs.entity.CommentPost;
import com.bbs.entity.MainPost;
import com.bbs.entity.Post;
import com.bbs.entity.Topic;
import com.bbs.enuma.PostType;
import com.bbs.parameter.PostCommentForm;
import com.bbs.parameter.PostTopicForm;
import com.bbs.service.ForumService;
import com.bbs.service.UserService;
import com.bbs.vo.VTopic;

@RestController
@RequestMapping("forum")
@Transactional
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
	public List<VTopic> showVTopicByUserId(@PathVariable("userId") long userId,
			@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		return forumService.getPagedVTopics(userId, pageNo, pageSize);
	}
	
	@GetMapping("topic/title/{title}")
	public List<VTopic> searchVTopics(@PathVariable("title") String title,
			@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		return forumService.queryVTopics(title, pageNo, pageSize);
	}
	
	@PostMapping("topic")
	public void postTopic(@RequestBody PostTopicForm p) {
		Topic topic = new Topic(p);
		Post post = new Post();
		post.setContent(p.getContent());
		post.setPostType(PostType.MainPost);
		forumService.addTopic(topic, post);
	}
	
	@PutMapping("topic/{topicId}")
	public void putTopic(@RequestBody PostTopicForm p, @PathVariable("topicId") long topicId) {
		forumService.updateTopic(new Topic(p));
		Post post = new Post();
		post.setContent(p.getContent());
		post.setUserId(p.getUserId());
		post.setPostType(PostType.MainPost);
		forumService.updatePost(post);
	}
	
	@DeleteMapping("topic/{topicId}")
	public void deleteTopic(@PathVariable("topicId") long topicId)	 {
		forumService.deleteTopic(topicId);
	}
	
	@GetMapping("comment/topic_id/{topicId}")
	public List<CommentPost> getComments(@PathVariable("topicId") long topicId,
			@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		return forumService.getPagedCommentsByTopicId(topicId, pageNo, pageSize);
		
	}
	
	@PostMapping("comment")
	public void postComment(@RequestBody PostCommentForm p) {
		CommentPost comment = new CommentPost(p);
		forumService.addPost(comment);
	}
	
	@DeleteMapping("comment/{commentId}")
	public void deleteComment(@PathVariable("commentId") long commentId) {
		forumService.deletePost(commentId);
	}
	
	
	
	@GetMapping("main_post/topic_id/{topicId}")
	public MainPost getMainPost(@PathVariable("topicId") long topicId) {		
		return forumService.getMainPostByTopicId(topicId);
	}
	
	


	
}
