package com.bbs.entity;

import java.io.Serializable;

public class CommentPost extends Post implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long replyPostId;

	public Long getReplyPostId() {
		return replyPostId;
	}

	public void setReplyPostId(long replyPostId) {
		this.replyPostId = replyPostId;
	}
}
