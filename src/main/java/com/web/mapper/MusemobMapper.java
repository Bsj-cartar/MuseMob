package com.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.dto.InstBoard;
import com.web.dto.Musemob;

@Mapper
public interface MusemobMapper {
	void insert(Musemob musemob);
	List<InstBoard> findchampionPost();
	List<InstBoard> findchallengerPost();
	
	List<Musemob> findAllWithPost();
	
	void championPointUp(int musemobid, int championpoint);
	void challengerPointUp(int musemobid, int challengerpoint);
	List<Musemob> findOneDayAgo();
}
