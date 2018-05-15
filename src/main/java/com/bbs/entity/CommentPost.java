package com.bbs.entity;

import java.io.Serializable;

import com.bbs.enuma.PostType;
import com.bbs.parameter.PostCommentForm;
import com.bbs.vo.VPost;

public class CommentPost extends VPost implements Serializable{

	/**
	 * 
	 */
	public CommentPost() {};
	
	public CommentPost(PostCommentForm p) {
		this.replyPostId = p.getReplyTo();
		this.setContent(p.getContent());
		this.setPostType(PostType.CommentPost);
		this.setTopicId(p.getTopicId());
		this.setUserId(p.getUserId());
	}
	private static final long serialVersionUID = 1L;
	private long replyPostId;

	public Long getReplyPostId() {
		return replyPostId;
	}

	public void setReplyPostId(long replyPostId) {
		this.replyPostId = replyPostId;
	}
}
