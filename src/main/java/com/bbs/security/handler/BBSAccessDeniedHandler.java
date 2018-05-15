package com.bbs.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.bbs.msg.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class BBSAccessDeniedHandler implements AccessDeniedHandler {

	public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException err)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		Message msg = new Message(err.toString());
		res.getWriter().write(Message.writeMsgAsString(msg));
	}

}
