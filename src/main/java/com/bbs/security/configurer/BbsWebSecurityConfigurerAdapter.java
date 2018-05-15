package com.bbs.security.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.bbs.properties.SecurityProperties;
import com.bbs.security.handler.BBSFailureHandler;
import com.bbs.security.handler.BBSSuccessHandler;
import com.bbs.service.BbsUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( prePostEnabled = true)
public class BbsWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
	
	@Autowired
	BbsUserDetailsService userDetailsService;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	SecurityProperties securityProperties;
	
	@Autowired
	BBSSuccessHandler successHandler;
	
	@Autowired
	BBSFailureHandler failureHandler;
	
	@Autowired
	AccessDeniedHandler accessDeniedHandler;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		
//			.passwordEncoder(passwordEncoder);
	}
	
	public void configure(WebSecurity webSecurity) {
		webSecurity.ignoring().antMatchers("/resources/**");
	}

	public void configure(HttpSecurity auth) throws Exception {
		
		System.out.println(securityProperties.getLoginProcessingUrl());
		auth.csrf().disable()
		.formLogin()
			.loginPage(securityProperties.getLoginUrl())
			.loginProcessingUrl(securityProperties.getLoginProcessingUrl())
			.usernameParameter("username")
			.passwordParameter("password")
			.successHandler(successHandler)
			.failureHandler(failureHandler)
		.and().exceptionHandling().accessDeniedHandler(accessDeniedHandler)
		.and()
			.logout().logoutUrl(securityProperties.getLogoutUrl())
		.and()
		.authorizeRequests()
		.antMatchers(securityProperties.getPermitUrls()).permitAll()
		.anyRequest().authenticated();
	}
}
