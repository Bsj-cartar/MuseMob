package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.dto.InstBoard;
import com.web.service.BoardService;
import com.web.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	BoardService boardService;

	@RequestMapping(value = "/login/loginAccount", method = RequestMethod.POST)
	public String loginAccount(HttpServletRequest request) throws Exception {
		String uid = request.getParameter("id");
		String upw = request.getParameter("pw");

		int status = loginService.loginMemberAccount(uid, upw);

		HttpSession session = request.getSession();
		if (status == 1) {
			session.setMaxInactiveInterval(10 * 60);
			session.setAttribute("login", uid);
			

			loginService.accountPointPlus(uid);
			session.setAttribute("point", loginService.accountPointCheck(uid));

			List<InstBoard> instBoards = boardService.recentlyBoardList(uid);
			session.setAttribute("recentlyPost", instBoards);

			return "welcomePost";
		} else {
			return "loginPost";
		}

	}

	@RequestMapping("/log_out")
	public String logoutAccount(HttpSession session) {
		session.invalidate();

		return "redirect:/";
	}

}
