package com.web.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.mapper.AccountMapper;

@Controller
public class RegisterController {
	/*
	 * @Autowired private RegisterService registerService;
	 * 
	 * //reg GET
	 * 
	 * @RequestMapping(value="/reg.do", method=RequestMethod.GET) public void
	 * signupGET() {
	 * 
	 * } //reg POST
	 * 
	 * @RequestMapping(value="/reg.do", method=RequestMethod.POST) public String
	 * signupPOST(Account account) { RegisterService.insertMember(account);
	 * 
	 * return "main"; }
	 */

	@RequestMapping(value = "/login/registerAccount", method = RequestMethod.POST)
	public String doRegister(Model model, HttpServletRequest request) throws IOException {
		
		  request.setCharacterEncoding("UTF-8");
		  
		  Enumeration<String> uAccount = request.getParameterNames();
		  while(uAccount.hasMoreElements()) { String name = uAccount.nextElement();
		  
		  String[] values = request.getParameterValues(name);
		  
		  /* Logger */
		  for(String value : values) System.out.println("name=" + name +
		  ",value=" + value );
		  
		  /*Model 전달*/ 
		  model.addAttribute("name", values);
		  
		  }
		 

		System.out.println("GET 방식 요청");

		return "temp";
	}

}