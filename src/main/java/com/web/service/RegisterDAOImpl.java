package com.web.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.RegisterDAO;
import com.web.dto.Account;

public class RegisterDAOImpl implements RegisterDAO{
	@Autowired
	private SqlSession session;

	public void insertMember(Account account) {
		session.insert("insertMember", account);
		
	}
	
}
