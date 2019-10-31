package com.web.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.web.dto.Account;

@Mapper
public interface AccountMapper {
	Account findOne(int id);
	void insert(Account account);
}
