package com.bbs.vo;

import java.io.Serializable;

import com.bbs.entity.Post;

public class VPost extends Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private VUser user;

	public VUser getUser() {
		return user;
	}

	public void setUser(VUser user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
