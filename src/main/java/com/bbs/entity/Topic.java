package com.bbs.entity;

import java.util.Date;

import com.bbs.parameter.PostTopicForm;

public class Topic {
	
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_topic.id
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_topic.broad_id
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	private Integer broadId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_topic.user_id
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	private Long userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_topic.title
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	private String title;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_topic.views
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	private Integer views;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_topic.digest
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	private Boolean digest;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_topic.replies
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	private Integer replies;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_topic.id
	 * @return  the value of t_topic.id
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_topic.id
	 * @param id  the value for t_topic.id
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_topic.broad_id
	 * @return  the value of t_topic.broad_id
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public Integer getBroadId() {
		return broadId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_topic.broad_id
	 * @param broadId  the value for t_topic.broad_id
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public void setBroadId(Integer broadId) {
		this.broadId = broadId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_topic.user_id
	 * @return  the value of t_topic.user_id
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_topic.user_id
	 * @param userId  the value for t_topic.user_id
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_topic.title
	 * @return  the value of t_topic.title
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_topic.title
	 * @param title  the value for t_topic.title
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_topic.views
	 * @return  the value of t_topic.views
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public Integer getViews() {
		return views;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_topic.views
	 * @param views  the value for t_topic.views
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public void setViews(Integer views) {
		this.views = views;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_topic.digest
	 * @return  the value of t_topic.digest
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public Boolean getDigest() {
		return digest;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_topic.digest
	 * @param digest  the value for t_topic.digest
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public void setDigest(Boolean digest) {
		this.digest = digest;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_topic.replies
	 * @return  the value of t_topic.replies
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public Integer getReplies() {
		return replies;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_topic.replies
	 * @param replies  the value for t_topic.replies
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public void setReplies(Integer replies) {
		this.replies = replies;
	}

	public Topic() {
		super();
	}
	
	public Topic(PostTopicForm p) {
		this.broadId = p.getBroadId();
		this.title = p.getTitle();
		this.userId = p.getUserId();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.append(title).toString();
	}
}