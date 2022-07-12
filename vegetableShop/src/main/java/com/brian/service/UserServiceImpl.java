package com.brian.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.dao.UserDAO;
import com.brian.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User getUser(String userName, String pwd) {
		User user = userDAO.getUserByNameAndPwd(userName, pwd);
		return user;
	}

	@Override
	public boolean isPwdCorrect(String userName, String pwd) {
		User user = userDAO.getUserByNameAndPwd(userName, pwd);
		if(user == null) return false;
		else return true;
	}

	@Override
	public boolean isUserExist(String userName) {
		User user = userDAO.getUserByName(userName);
		if(user == null) return false;
		else return true;
	}

	@Override
	public void addUser(String userName, String pwd) {
		User user = new User();
		user.setUserName(userName);
		user.setPwd(pwd);
		userDAO.addUser(user);
	}

}
