package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.dto.Musemob;
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
	
	/* 테스트 메소드 */
	@RequestMapping("/temp")
	public String test1(Model model) {
		List<Musemob> musemobs = musemobService.findAllWithPost();
		model.addAttribute("musemobs", musemobs);
		
		return "test_grid";
		
	}
	
	/* 테스트 페이지 */
	@RequestMapping("/test")
	public String testGrid() {
		return "test_grid";
	}
	
	
	
	
	/*
	 * // 메인 do 호출시 메인페이지 호출
	 * 
	 * @RequestMapping("/main.do") public String main() { return "index"; }
	 */
}
