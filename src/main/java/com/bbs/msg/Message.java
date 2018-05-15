package com.bbs.msg;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object content;
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	public static String writeMsgAsString(Message msg) throws JsonProcessingException {
		return objectMapper.writeValueAsString(msg);
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public Message(Object content) {
		super();
		this.content = content;
	}
	
}
