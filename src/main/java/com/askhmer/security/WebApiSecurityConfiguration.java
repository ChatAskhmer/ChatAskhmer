package com.askhmer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class WebApiSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private Environment environment;
	
	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		super.configure(auth);
		
		auth.inMemoryAuthentication()
			.withUser(environment.getProperty("chatAskhmer.admin"))
			.password(environment.getProperty("chatAskhmer.code"))
			.roles("API");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http
			.csrf()
			.disable();
		http
			.authorizeRequests()
			.antMatchers("/api/**")
			.hasRole("API")
			.anyRequest()
			.authenticated()
		.and()
			.httpBasic()
		.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
	}

}
