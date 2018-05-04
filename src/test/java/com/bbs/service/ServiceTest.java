package com.bbs.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bbs.entity.Broad;
import com.bbs.entity.CommentPost;
import com.bbs.entity.MainPost;
import com.bbs.entity.Topic;
import com.bbs.entity.User;
import com.bbs.mapper.PostMapper;
import com.bbs.vo.VTopic;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ServiceTest extends BaseJunit4Test {

	@Autowired
	UserService userService;
	
	private MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	ForumService forumService;
	
	private static final Logger LOGGER = Logger.getLogger(ServiceTest.class);
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	public void testUserService() {
		
		List<User> users = userService.getAllUsers();
		User user1 = userService.getUserById(1L);
		User user2 = userService.getUserByUsername("joy");
		userService.lockUser("瑜亮");
		userService.unlockUser("joy");
		List<Topic> topics = forumService.queryPagedTopicLikeTitle("测试", 3, 2);
		
		
		for (Topic topic : topics) {
			LOGGER.info(topic.getTitle());
		}
		LOGGER.info(users.size());
		LOGGER.info(user1.getLockType());
		LOGGER.info(user2.getUsername());
	}
	
	@Test
	public void testForumService() {
		MainPost mainPost = forumService.getMainPostByTopicId(1L);
		LOGGER.info("获取某话题的主题帖子: "+mainPost.getContent());	
		
		/* 测试like搜索 */
		List<Topic> topics = forumService.queryPagedTopicLikeTitle("电影", 0, 5);
		LOGGER.info("根据某关键词搜索类似话题："+topics);
		
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
		
//		测试返回VO的话题功能，用于视图渲染
		List<VTopic> vtopics = forumService.getPagedVTopics(1L);
		
		LOGGER.info("vo Vtopic: " + vtopics.get(0).getUsername());
	}
	
	@Test
	public void testController() throws Exception {
		/*测试getAllBroad方法*/
		String url = "/forum/all";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
				.accept(MediaType.APPLICATION_JSON)
		).andReturn();
		
		String data = mvcResult.getResponse().getContentAsString();
		
		ObjectMapper om = new ObjectMapper();
		List<Broad> broads = om.readValue(data, List.class);
		
		LOGGER.info("json解析后的对象" + broads);
		LOGGER.info("GET收到的数据: " + data);
		
		/*测试getAllBroadByBroadId方法*/
		url = "/forum/topic/broad/1";
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON)
				).andReturn();
		
		data = mvcResult.getResponse().getContentAsString();
		
		LOGGER.info("json解析后的broad中的topic: " + data);
	}
}
