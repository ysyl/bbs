package com.bbs.parameter;

public class PostCommentForm {

	private long replyTo;
	private String content;
	private long UserId;
	private long topicId;
	public long getReplyTo() {
		return replyTo;
	}
	public void setReplyTo(long replyTo) {
		this.replyTo = replyTo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long userId) {
		UserId = userId;
	}
	public long getTopicId() {
		return topicId;
	}
	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}
	
	
}
