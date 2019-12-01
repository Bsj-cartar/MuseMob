package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.web.dto.Musemob;
import com.web.mapper.AccountMapper;
import com.web.mapper.InstBoardMapper;
import com.web.mapper.MusemobMapper;

@Service
public class BoardTimer {
	@Autowired AccountMapper accountMapper;
	@Autowired InstBoardMapper instBoardMapper;
	@Autowired MusemobMapper musemobMapper;
	@Scheduled(cron = "0 0 0 * 0 0")
	public void tick() throws InterruptedException {
		List<Musemob> musemobs = musemobMapper.findOneDayAgo();
		
		for(Musemob mm : musemobs) {
			if(mm.getChallengerpoint() > mm.getChampionpoint()) {
				String uid = instBoardMapper.findPostidAccount(mm.getChallengerpoint());
				accountMapper.accountPointPlus(uid);
			}
			else {
				String uid = instBoardMapper.findPostidAccount(mm.getChampionpoint());
				accountMapper.accountPointPlus(uid);
			}
				
		
		}
		
	}

}
