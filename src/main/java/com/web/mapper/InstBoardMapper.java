package com.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.dto.Criteria;
import com.web.dto.InstBoard;

@Mapper
public interface InstBoardMapper {
	// 구현
	List<InstBoard> findAll()throws Exception;
	List<InstBoard> listPage(int page)throws Exception;
	InstBoard findOne(int postid)throws Exception;
	void insert(InstBoard instBoard)throws Exception;
	List<InstBoard> selectBoardList(Criteria cri)throws Exception;
	Integer countBoardList(int instsection)throws Exception;
	List<InstBoard> recentlyBoardList(String uid)throws Exception;
	List<InstBoard> recentlyBoardListInst(String uid, int inst)throws Exception;
	

	String findPostidAccount(int postid);

	void update(InstBoard instBoard)throws Exception;
	void delete(InstBoard instBoard)throws Exception;
	
}
