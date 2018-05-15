package com.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class LoginRedirectController {

	@GetMapping("login_form")
	public String redirect() {
		return "login";
	}
}
