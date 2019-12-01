package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.dto.Criteria;
import com.web.dto.InstBoard;
import com.web.dto.Musemob;
import com.web.dto.PageMaker;
import com.web.service.BoardService;
import com.web.service.LoginService;
import com.web.service.MusemobService;

@Controller
public class BoardController {
	@Autowired LoginService loginService;
	@Autowired BoardService boardService;
	@Autowired MusemobService musemobService;
	
	@RequestMapping("/board/{inst}")
	public ModelAndView openGuitarList(@PathVariable String inst, Criteria cri, 
										HttpServletRequest request) throws Exception {
	
		ModelAndView mav = new ModelAndView("board/" + inst);
		int inst_num = boardService.instSectionConversion(inst);
		
		cri.setInstSection(inst_num);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.countBoardList());
		
		List<InstBoard> list = boardService.selectBoardList(cri);
		
		List<Musemob> musemobs = musemobService.findAllWithPost();
		
		HttpSession session = request.getSession();
		String uid = (String) session.getAttribute("login");
		if(uid != null) {
			System.out.println(uid);
		List<InstBoard> recentlyPostInst = boardService.recentlyBoardListInst(uid, inst_num);
		mav.addObject("recentlyPostInst", recentlyPostInst);
		}
		
		
		mav.addObject("musemobs", musemobs);
		mav.addObject("page", cri.getPage());
		mav.addObject("list", list);
		mav.addObject("pageMaker", pageMaker);
		
		return mav;
	}
	
	@PostMapping("/board/{inst}/newchallenger")
	public String newchallenger(@PathVariable String inst, HttpServletRequest request) throws Exception {
		String challengerpostid = request.getParameter("challenger");
		String championpostid = request.getParameter("champion");
		
		Musemob musemob = new Musemob();
		
		musemob.setChallengerpostid(Integer.parseInt(challengerpostid));
		System.out.println("챌린저 : " + Integer.parseInt(challengerpostid));
		musemob.setChampionpostid(Integer.parseInt(championpostid));
		System.out.println("챔피온 : " + Integer.parseInt(championpostid));
		
		String creationdate = boardService.WhatTimeIsItNow();
		musemob.setCreationdate(creationdate);
		
		musemobService.newMuseMobUpload(musemob);
		
		return "redirect:/board/" + inst;
		
	}
	
	@GetMapping("/board/postupload")
	public String postUploadForm(Model model) {
		return "board/boardPostUpload";
	}

	@PostMapping("/board/postupload")
	public String postUpload(HttpServletRequest request, HttpSession session) throws Exception {
		InstBoard instBoard = new InstBoard();
		
		instBoard.setPosttitle(request.getParameter("title"));
		
		String url = request.getParameter("videourl"); 
		instBoard.setPostvideourl(boardService.videoUrlConverter(url));

		String uid = (String) session.getAttribute("login");
		instBoard.setUid(uid);
		
		String creationdate = boardService.WhatTimeIsItNow();
		instBoard.setCreationdate(creationdate);
		
		String temp = request.getParameter("instsection");
		int instsection = boardService.instSectionConversion(temp);
		
		instBoard.setInstsection(instsection);
		
		boardService.postUpload(instBoard);
		
		return "redirect:/board/" + temp;
		
		
	}
	
	@RequestMapping("/board/post/{postid}")
	public String getBoardContent(@PathVariable int postid, Model model,
								HttpServletRequest request) throws Exception {
		InstBoard instBoard = boardService.getBoardContent(postid);
		int instSection = instBoard.getInstsection();
		String inst = boardService.instSectionNumberConversion(instSection);
		
		HttpSession session = request.getSession();
		String uid = (String) session.getAttribute("login");
		if(uid != null) {
			System.out.println(uid);
		List<InstBoard> recentlyPostInst = boardService.recentlyBoardListInst(uid, instSection);
		model.addAttribute("recentlyPostInst", recentlyPostInst);
		}
		model.addAttribute("inst", inst);
		model.addAttribute("boardContent", instBoard);
		model.addAttribute("beforeInstSection", instSection);

		return "board/boardPostDetail";
	}
	
	@RequestMapping("/board/post/{postid}/update")
	public String updateBoardContentForm(@PathVariable("postid")int postid, Model model) throws Exception {
		InstBoard instBoard = boardService.getBoardContent(postid);
		
		model.addAttribute("boardContent", instBoard);
		
		return "board/boardPostUpdate";
	}
	
	@RequestMapping(value="/board/post/{postid}/update", method=RequestMethod.POST)
	public String updateBoardContent(@PathVariable("postid")int postid, 
									HttpServletRequest request, HttpSession session) throws Exception {
		InstBoard instBoard = new InstBoard();
		
		instBoard.setPostid(postid);
		
		instBoard.setPosttitle(request.getParameter("title"));
		
		instBoard.setPostvideourl(request.getParameter("videourl"));

		String uid = (String) session.getAttribute("login");
		instBoard.setUid(uid);
		
		String temp = request.getParameter("instsection");
		int instsection = boardService.instSectionConversion(temp);
		instBoard.setInstsection(instsection);
		
		boardService.postUpdate(instBoard);
		
		return "redirect:/board/" + temp;
	}
	

	@RequestMapping("/board/post/{postid}/delete")
	public String deleteBoardContentForm(@PathVariable("postid")int postid, Model model) throws Exception {
		InstBoard instBoard = boardService.getBoardContent(postid);
		String url = boardService.instSectionNumberConversion(instBoard.getInstsection());
		
		boardService.postDelete(instBoard);
		
		return "redirect:/board/" + url;
	}
	
	@GetMapping("/board/{inst}/{musemobid}/chapmchoice")
	public String cheerChamp(@PathVariable String inst,  
							@PathVariable int musemobid, Model model) {
		musemobService.championPointUp(musemobid, 5);
		model.addAttribute("inst", inst);
		return "cheerPost";	
	}
	
	@GetMapping("/board/{inst}/{musemobid}/challchoice")
	public String cheerchall(@PathVariable String inst,  
							@PathVariable int musemobid, Model model) {
		musemobService.challengerPointUp(musemobid, 5);
		model.addAttribute("inst", inst);
		return "cheerPost";	
	}
	
	@GetMapping("/board/{inst}/{postid}/support")
	public String cheerPost(@PathVariable String inst,
							@PathVariable String postid, Model model) throws Exception {
		InstBoard instBoard = boardService.getBoardContent(Integer.parseInt(postid));
		loginService.accountPointPlus(instBoard.getUid());
		
		model.addAttribute("inst", inst);
	return "cheerPost";
	}
}

