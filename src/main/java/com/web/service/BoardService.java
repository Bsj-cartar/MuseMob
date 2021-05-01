package com.web.service;

import java.util.List;

import com.web.dto.Criteria;
import com.web.dto.InstBoard;

public interface BoardService {
	List<InstBoard> selectBoardList(Criteria cri) throws Exception;
	int countBoardList(int instsection) throws Exception;
	int instSectionConversion(String inst)throws Exception;
	String instSectionNumberConversion(int inst)throws Exception;
	String WhatTimeIsItNow() throws Exception;
	void postUpload(InstBoard instBoard) throws Exception;
	String videoUrlConverter(String postvideourl) throws Exception;
	String thumbnailUrlConverter(String postvideourl) throws Exception;
	String playerUrlConverter(String postvideourl) throws Exception;
	InstBoard getBoardContent(int postid) throws Exception;
	void postUpdate(InstBoard instBoard) throws Exception;
	void postDelete(InstBoard instBoard) throws Exception;
	
	List<InstBoard> recentlyBoardList(String uid) throws Exception;
	List<InstBoard> recentlyBoardListInst(String uid, int inst) throws Exception;
	
}
