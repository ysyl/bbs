package com.bbs.parameter;

public class PostTopicForm {

	private int broadId;
	private long userId;
	private String title;
	private String content;
	public int getBroadId() {
		return broadId;
	}
	public void setBroadId(int broadId) {
		this.broadId = broadId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
