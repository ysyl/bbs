package com.bbs.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.bbs.msg.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class BBSFailureHandler implements AuthenticationFailureHandler {

	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		Message msg = new Message("login failure");
		ObjectMapper ob = new ObjectMapper();
		String result = ob.writeValueAsString(msg);
		res.getWriter().println(result);
	}

}
