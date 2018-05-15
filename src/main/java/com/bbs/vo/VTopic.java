package com.bbs.vo;

import java.util.Date;

import com.bbs.entity.Topic;

public class VTopic extends Topic {

	private String username;
	
	private Date lastPostTime;
	
	private String lastPostUser;
	
	private String lastPostUserId;
	
	public String toString() {
		return this.getTitle() + " username = " + this.getUsername() + " lastPostUser: " + this.lastPostUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
