package com.bbs.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.bbs.msg.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class BBSSuccessHandler implements AuthenticationSuccessHandler {

	
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		Message msg = new Message("login successful");
		ObjectMapper ob = new ObjectMapper();
		String result = ob.writeValueAsString(msg);
		res.getWriter().println(result);
	}

}
