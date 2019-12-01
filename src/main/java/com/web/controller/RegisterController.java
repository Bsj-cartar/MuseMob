package com.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.dto.Account;
import com.web.service.RegisterService;

@Controller
public class RegisterController {
	@Autowired
	RegisterService registerService;

	//아이디 중복 확인 (AJAX 호출)
	@ResponseBody
	@RequestMapping(value = "/login/idCheck", method = RequestMethod.POST)
	public int postIdCheck(HttpServletRequest request) throws Exception {
		String userId = request.getParameter("uid");
		Account idCheck = registerService.idCheck(userId);

		int result = 0;

		if (idCheck != null) {
			result = 1;
		}
		return result;

	}
	//회원가입 요청
	@RequestMapping(value = "/login/registerAccount", method = RequestMethod.POST) 
	public String registerAccount(Account account) throws Exception {
	  
		registerService.insertAccount(account);
		
		return "redirect:/login";
	}

}