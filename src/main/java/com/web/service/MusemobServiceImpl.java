package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dto.InstBoard;
import com.web.dto.Musemob;
import com.web.mapper.MusemobMapper;


@Service
public class MusemobServiceImpl implements MusemobService{

	@Autowired MusemobMapper musemobMapper;
	
	@Override
	public void newMuseMobUpload(Musemob musemob) {
		musemobMapper.insert(musemob);
		
	}

	@Override
	public List<InstBoard> selectChampionPost() {

		return musemobMapper.findchampionPost();
	}

	@Override
	public List<InstBoard> selectchallengerPost() {

		return musemobMapper.findchallengerPost();
	}

	@Override
	public void championPointUp(int musemobid, int championpoint) {
		musemobMapper.championPointUp(musemobid, championpoint);
		
	}

	@Override
	public void challengerPointUp(int musemobid, int challengerpoint) {
		musemobMapper.challengerPointUp(musemobid, challengerpoint);
		
	}

	@Override
	public List<Musemob> findOneDayAgo() {
		
		return musemobMapper.findOneDayAgo();
	}

	@Override
	public List<Musemob> findAllWithPost() {
		List<Musemob> musemobs = musemobMapper.findAllWithPost();
		return musemobs;
	}
	
	

}
