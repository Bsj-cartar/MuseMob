package com.web.service;

import com.web.dto.Account;

public interface RegisterService {
	//회원가입 service
	public void insertAccount(Account account);
	public Account idCheck(String uid);
}
