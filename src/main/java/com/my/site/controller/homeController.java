package com.my.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {	
	@RequestMapping("/usr/home/main")
	public String showMain() {		
		return "home/main";
	}
	
}
