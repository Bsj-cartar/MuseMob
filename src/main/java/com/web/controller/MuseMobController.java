package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.service.BoardTimer;
import com.web.service.MusemobService;

@Controller
@RequestMapping("/")
public class MuseMobController {
	@Autowired BoardTimer boardTimer;
	@Autowired MusemobService musemobService;
	
	
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
	@RequestMapping("/elements")
	public String elements(Model model) {
		return "elements";
	}
	@RequestMapping("/generic")
	public String generic(Model model) {
		return "generic";
	}
	@RequestMapping("/login/register")
	public String register(Model model) {
		return "register";
	}
	
	
}
