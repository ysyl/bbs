package com.bbs.properties;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:security.properties")
public class SecurityProperties {

	@Value("${security.loginUrl:/login}")
	private String loginUrl;
	
	
	@Value("${security.logoutUrl:/login?out}")
	private String logoutUrl;
	
	@Value("${security.permitUrl:/login}")
	private String[] permitUrls;

	@Value("${security.loginProcessingUrl:/login}")
	private String loginProcessingUrl;
	
	public String getLoginProcessingUrl() {
		return loginProcessingUrl;
	}

	public void setLoginProcessingUrl(String loginProcessingUrl) {
		this.loginProcessingUrl = loginProcessingUrl;
	}

	public String[] getPermitUrls() {
		return permitUrls;
	}

	public void setPermitUrls(String[] permitUrls) {
		this.permitUrls = permitUrls;
	}



	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}
	
	
}
