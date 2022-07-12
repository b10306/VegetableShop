package com.brian.dao;

import com.brian.entity.User;

public interface UserDAO {
	void addUser(User user);
	User getUserByName(String userName);
	User getUserByNameAndPwd(String userName, String pwd);
	User getUserById(int id);
}
