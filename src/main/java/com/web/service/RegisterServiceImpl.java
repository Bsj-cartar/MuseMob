package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.RegisterDAO;
import com.web.dto.Account;

public class RegisterServiceImpl implements RegisterService{

	@Autowired
	private RegisterDAO dao;
	
	@Override
	public void insertMember(Account account) {
		dao.insertMember(account);
		
	}
	
}
