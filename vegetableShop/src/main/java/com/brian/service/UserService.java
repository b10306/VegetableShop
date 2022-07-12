package com.brian.service;

import com.brian.entity.User;

public interface UserService {
	User getUser(String userName, String pwd);
	boolean isPwdCorrect(String userName, String pwd);
	boolean isUserExist(String userName);
	void addUser(String userName, String pwd);
}
