package com.web.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.web.dto.Account;
import com.web.dto.AccountPoint;

@Mapper
public interface AccountMapper {
	void insertAccount(Account account);
	Account idCheck(String uid);
	
	void accountPointPlus(String uid);
	int accountPointCheck(String uid);
	
	
	
	
}
