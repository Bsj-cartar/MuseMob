package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dto.Account;
import com.web.mapper.AccountMapper;


@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public void insertAccount(Account account) {
		accountMapper.insertAccount(account);
		
	}

	@Override
	public Account idCheck(String uid) {
		return accountMapper.idCheck(uid);
	}
	
}
