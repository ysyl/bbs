package com.bbs.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bbs.base.BaseJunit4Test;
import com.bbs.entity.Broad;
import com.bbs.entity.CommentPost;
import com.bbs.entity.MainPost;
import com.bbs.entity.Permission;
import com.bbs.entity.Topic;
import com.bbs.entity.User;
import com.bbs.entity.UserPrincipal;
import com.bbs.exception.UserIsNotFoundException;
import com.bbs.mapper.PostMapper;
import com.bbs.vo.VTopic;
import com.bbs.vo.VUser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ServiceTest extends BaseJunit4Test {

	@Autowired
	UserService userService;
	
	private MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	ForumService forumService;
	
	@Autowired
	BbsUserDetailsService userDetailsService;

	
	private static final Logger LOGGER = Logger.getLogger(ServiceTest.class);
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testUserDetailsService() throws UserIsNotFoundException {
		UserPrincipal up = userService.getUserByUsername("verrickt");
		LOGGER.info(up.getUsername() + " and " + up.getLockType());

		@SuppressWarnings("unchecked")
		List<Permission> perms = (List<Permission>) up.getAuthorities();
		LOGGER.info(perms);
		for(Permission p: perms) {
			LOGGER.info(p.getAuthority());
		}
	}
	
	public void testUserService() throws UserIsNotFoundException {
		
		List<UserPrincipal> users = userService.getAllUsers();
		User user1 = userService.getUserById(1L);
		User user2 = userService.getUserByUsername("joy");
		userService.lockUser("瑜亮");
		userService.unlockUser("joy");
		
		
		
		LOGGER.info(users.size());
		LOGGER.info(user1.getLockType());
		LOGGER.info(user2.getUsername());
		
	}
	
	
	public void testForumService() {
		MainPost mainPost = forumService.getMainPostByTopicId(1L);
		LOGGER.info("获取某话题的主题帖子: "+mainPost.getContent());	
		
		/* 测试like搜索 */
		
		
		/*
		 * 测试获取评论功能
		 * */
		List<CommentPost> comments = forumService.getPagedCommentsByTopicId(mainPost.getTopicId(), 0, 2);
		
		LOGGER.info("获取某话题的所有评论： "+ comments);
		
		List<CommentPost> userComments = forumService.getPagedCommentsByUserId(1L, 0, 20);
		
		LOGGER.info("获取1L用户的所有评论：" + userComments);
		
//		测试添加版块管理员功能
		
		forumService.removeAllBroadManager();
		
		boolean isSuccessfulAddedBroadManager = forumService.addBroadManager(1, 1);
		LOGGER.info("是否成功添加论坛管理员： "+ isSuccessfulAddedBroadManager);
		
		List<User> allBroadManager = forumService.getAllBroadManager();
		LOGGER.info("获取所有论坛管理员：" + allBroadManager);		
		
//		测试获取话题功能
		List<Topic> topic2 = forumService.getAllTopicByBroadId(1);
		
		LOGGER.info("根据版块id获取的话题" + topic2);
		
//		测试返回VO的话题功能，用于视图渲染, 并且是重载的
		List<VTopic> vtopics = forumService.getPagedVTopics(1L, 0, 20);
		
		LOGGER.info("get vtopics By UserId: " + vtopics);
		
		List<VTopic> vtopics2 = forumService.getPagedVTopics(1, 0, 20);
		
		LOGGER.info("测试重载方法（版块ID）： " + vtopics2);
		
		vtopics2 = forumService.getPagedVTopics(2L, 0, 20);
		LOGGER.info("测试另一位用户的vtopic: " + vtopics2);
	}
	
	public void testController() throws Exception {
		/*测试getAllBroad方法*/
		String url = "/forum/all";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
				.accept(MediaType.APPLICATION_JSON)
		).andReturn();
		
		String data = mvcResult.getResponse().getContentAsString();
		
		
		LOGGER.info("GET收到的数据: " + data);
		
		/*测试getAllBroadByBroadId方法*/
		url = "/forum/topic/broad/1";
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON)
				).andReturn();
		
		data = mvcResult.getResponse().getContentAsString();
		
		LOGGER.info("json解析后的broad中的topic: " + data);
		
		/*测试获取VUser，查看是否包含密码 */
		String url2 = "/user/1";
		
		MvcResult mvcResult2 = mockMvc.perform(MockMvcRequestBuilders.get(url2).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		String data2 = mvcResult2.getResponse().getContentAsString();
		
		LOGGER.info("VUser: "+ data2);
		
		
		// 测试获取VPost 查看是否包含VUser字段
		url = "/forum/comment/topic_id/2";
		
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		data = mvcResult.getResponse().getContentAsString();
		
		LOGGER.info("测试VPost里是否含有VUser: " + data);
	}
}
