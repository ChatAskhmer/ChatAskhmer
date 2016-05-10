package com.askhmer.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {
	
	@RequestMapping(value = "/hom")
	public String homePage(){
		return "home";
	}

}
