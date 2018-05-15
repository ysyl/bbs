package com.bbs.controller;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bbs.exception.UnAuthenticatedException;
import com.bbs.exception.UserIsNotFoundException;
import com.bbs.msg.Message;

@ControllerAdvice
@RestController
public class ExceptionHandlerController {

	@ExceptionHandler(UnAuthenticatedException.class)
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public Message redirect() {
		return new Message("please login");
	}
	
	@ExceptionHandler(UserIsNotFoundException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Message loginError() {
		return new Message("user is no found");
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public Message unauthorized() {
		return new Message("this request is unauthorized");
	}
}
