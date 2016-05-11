package com.askhmer.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mangofactory.swagger.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class Main {
	
	
	@RequestMapping(value = "/")
	public String homePage(){
		return "home";
	}
		
	@RequestMapping(value = "/api")
	public String apiDocument(){
		return "index";
	}

}
