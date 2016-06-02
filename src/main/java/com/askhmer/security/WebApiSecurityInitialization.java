package com.askhmer.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class WebApiSecurityInitialization extends AbstractSecurityWebApplicationInitializer{
	public WebApiSecurityInitialization() {
		//init with security configuration
		super(WebApiSecurityConfiguration.class);
	}
}
