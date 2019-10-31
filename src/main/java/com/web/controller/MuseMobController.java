package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MuseMobController {
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
	
	@RequestMapping("/test")
	public String testGrid() {
		return "test_grid";
	}
	
	/* 게시판 연습 */
	@RequestMapping("/guitar")
	public String guitar() {
		return "guitar";
	}
	
	
	/*
	 * // 메인 do 호출시 메인페이지 호출
	 * 
	 * @RequestMapping("/main.do") public String main() { return "index"; }
	 */
}
