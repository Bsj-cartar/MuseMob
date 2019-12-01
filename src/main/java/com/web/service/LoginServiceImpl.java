package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dto.Account;
import com.web.dto.AccountPoint;
import com.web.mapper.AccountMapper;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	AccountMapper accountMapper;
	
	@Override
	public int loginMemberAccount(String uid, String upw) {
		
		Account db_account = accountMapper.idCheck(uid);
		String db_pw;
		if(db_account != null ) {
		db_pw = db_account.getUpw();
		}
		else {
			return 0;
		}
		if(db_pw.equals(upw)) {
			return 1;
		}
		else
			return 0;
		
		
	}

	@Override
	public void accountPointPlus(String uid) {
		accountMapper.accountPointPlus(uid);
		
	}

	@Override
	public int accountPointCheck(String uid) {
		int point = accountMapper.accountPointCheck(uid);
		return point;
	}


	
}
