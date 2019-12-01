package com.web.service;

import java.util.List;

import com.web.dto.InstBoard;
import com.web.dto.Musemob;

public interface MusemobService {
	void newMuseMobUpload(Musemob musemob);
	List<InstBoard> selectChampionPost();
	List<InstBoard> selectchallengerPost();
	List<Musemob> findOneDayAgo();
	void championPointUp(int musemobid, int championpoint);
	void challengerPointUp(int musemobid, int challengerpoint);
	
	List<Musemob> findAllWithPost();
}
