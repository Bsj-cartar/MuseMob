package com.web.service;

public interface LoginService {
	int loginMemberAccount(String uid, String upw);
	
	void accountPointPlus(String uid);
	int accountPointCheck(String uid);
	
}
