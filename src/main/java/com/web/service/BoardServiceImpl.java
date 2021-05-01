/* 게시판 관련 서비스 */

package com.web.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dto.Criteria;
import com.web.dto.InstBoard;
import com.web.mapper.InstBoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	InstBoardMapper instBoardMapper;
	
	@Override
	public List<InstBoard> selectBoardList(Criteria cri) throws Exception {
		return instBoardMapper.selectBoardList(cri);
	}

	@Override
	public int countBoardList(int instsection) throws Exception {
		
		return instBoardMapper.countBoardList(instsection);
	}

	@Override
	public int instSectionConversion(String inst) throws Exception {
		switch(inst) {
		case "vocal" :
			return 0;
		case "guitar" :
			return 1;
		case "drum" :
			return 2;
		case "bass" :
			return 3;
		case "etc" :
			return 4;
		}
		return -1;
	}

	@Override
	public String WhatTimeIsItNow() throws Exception {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
				
		Date time = new Date();
				
		String time1 = format1.format(time);
		
		return time1;
		
	}

	@Override
	public void postUpload(InstBoard instBoard) throws Exception {
		instBoardMapper.insert(instBoard);
	}

	@Override
	public String videoUrlConverter(String postvideourl) throws Exception {
		//https://youtu.be/UPbKqqpolQc
		//https://youtu.be/N_Tv3ljb9IE
		
		return postvideourl.substring(postvideourl.length()-11, postvideourl.length());
	}

	@Override
	public String thumbnailUrlConverter(String postvideourl) throws Exception {
		//UPbKqqpolQc
		String url = "http://i.ytimg.com/vi/+" + postvideourl + "/0.jpg";
		
		return url;
	}

	@Override
	public String playerUrlConverter(String postvideourl) throws Exception {
		//UPbKqqpolQc
		String url = "https://www.youtube.com/embed/" + postvideourl;
		return url;
	}

	@Override
	public InstBoard getBoardContent(int postid) throws Exception {
		
		return instBoardMapper.findOne(postid);
	}

	@Override
	public String instSectionNumberConversion(int inst) throws Exception {
		switch(inst) {
		case  0 :
			return "vocal";
		case  1 :
			return "guitar";
		case  2 :
			return "drum";
		case  3 :
			return "bass";
		case  4 :
			return "etc";
		}
		return "error";
	}

	@Override
	public void postUpdate(InstBoard instBoard) throws Exception {
		instBoardMapper.update(instBoard);
		
	}

	@Override
	public void postDelete(InstBoard instBoard) throws Exception {
		instBoardMapper.delete(instBoard);
		
	}

	@Override
	public List<InstBoard> recentlyBoardList(String uid) throws Exception {
		List<InstBoard> instBoards = instBoardMapper.recentlyBoardList(uid);
		
		return instBoards;
	}
	
	@Override
	public List<InstBoard> recentlyBoardListInst(String uid, int inst) throws Exception {
		List<InstBoard> instBoards = instBoardMapper.recentlyBoardListInst(uid, inst);
		return instBoards;
	}
	


	

}
