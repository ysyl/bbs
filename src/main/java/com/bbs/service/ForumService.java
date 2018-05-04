package com.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.entity.Broad;
import com.bbs.entity.CommentPost;
import com.bbs.entity.MainPost;
import com.bbs.entity.Post;
import com.bbs.entity.Topic;
import com.bbs.entity.User;
import com.bbs.mapper.BroadMapper;
import com.bbs.mapper.PostMapper;
import com.bbs.mapper.TopicMapper;
import com.bbs.mapper.UserMapper;
import com.bbs.vo.VTopic;

@Service
public class ForumService {

	@Autowired
	TopicMapper topicMapper;
	
	@Autowired
	PostMapper postMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	BroadMapper broadMapper;
	
	public boolean addBroad(Broad broad) {
		return broadMapper.insert(broad) > 0;
	}
	
	public boolean removeBroad(int broadId) {
		int rm = broadMapper.deleteByPrimaryKey(broadId);
		return rm > 0;
	}
	
	public boolean removeBroad(String broadName) {
		return broadMapper.deleteByName(broadName) > 0;
	}
	
	public boolean addTopic(Topic topic) {
		return topicMapper.insert(topic) > 0;
	}
	
	public boolean removeTopic(long topicId) {
		return topicMapper.deleteByPrimaryKey(topicId) >0;
	}
	
	public boolean removeTopic(String title) {
		return topicMapper.deleteByTitle(title) > 0;
	}
	
	public boolean addPost(Post post) {
		return postMapper.insert(post) > 0;
	}
	
	public boolean removePost(long postId) {
		return postMapper.deleteByPrimaryKey(postId) > 0;
	}
	
	public List<Topic> queryPagedTopicLikeTitle(String title, int pageNo, int pageSize) {
		return topicMapper.selectPagedTopic(title, pageNo, pageSize);
	}
	
	public List<Broad> getAllBroad() {
		return broadMapper.selectAllBroad();
	}
	
	public Topic getTopicById(long topicId) {
		return topicMapper.selectByPrimaryKey(topicId);
	}
	
	public Broad getBroadById(int broadId) {
		return broadMapper.selectByPrimaryKey(broadId);
	}
	
	public List<Topic> getPagedTopicsByUserId(long userId, int pageNo, int pageSize) {
		return topicMapper.selectPagedTopicsByUserId(userId, pageNo, pageSize);
	}
	
	public List<CommentPost> getPagedCommentsByUserId(long userId, int pageNo, int pageSize) {
		return postMapper.selectPagedCommentPostsByUserId(userId, pageNo, pageSize);
	}
	
	
	public boolean makeDigestTopicByTopicId(long topicId) {
		return topicMapper.makeDigestTopicById(topicId) > 0;
	}
	
	public boolean updateTopic(Topic topic) {
		return topicMapper.updateByPrimaryKey(topic) > 0;
	}
	
	public boolean updateBroad(Broad broad) {
		return broadMapper.updateByPrimaryKey(broad) > 0;
	}
	
	public List<Broad> queryAllBroadLikeName(String broadName) {
		return broadMapper.queryAllBroadLikeName(broadName);
	}
	
	public MainPost getMainPostByTopicId(long topicId) {
		return postMapper.selectMainPostByTopicId(topicId);
	}
	
	public List<CommentPost> getPagedCommentsByTopicId(long topicId, int pageNo, int pageSize) {
		return postMapper.selectPagedCommentPostsByTopicId(topicId, pageNo, pageSize);
	}
	
	public boolean addBroadManager(int broadId, long userId) {
		return broadMapper.addBroadManagerByBroadIdAndUserId(broadId, userId) > 0;
	}
	
	public boolean removeBroadManagerByBroadIdAndUserId(int broadId, long userId) {
		return broadMapper.deleteBroadManager(broadId, userId) > 0;
	}
	
	public List<User> getAllBroadManager() {
		return broadMapper.selectAllBroadManager();
	}
	
	public boolean removeAllBroadManager() {
		return broadMapper.deteleAllBroadManager() > 0;
	}
	
	public List<Topic> getAllTopicByBroadId(int broadId) {
		return broadMapper.selectPagedTopicsByBroadId(broadId);
	}
	
	public List<VTopic> getPagedVTopics(long userId) {
		return topicMapper.selectPagedVTopicsByUserId(userId);
	}
	
}
