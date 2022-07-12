package com.brian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brian.entity.User;
import com.brian.service.UserService;

@Controller
public class CustomerController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET, produces = "application/json; charset = utf-8")
	@ResponseBody
	public String checkRepeatedUser(@RequestParam("uname") String userName) {
		if(userService.isUserExist(userName)) {
			return "使用者已存在";
		}else {
			return "此名稱可使用";
		}
	}
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public String addUser(@RequestParam("uname") String userName, String pwd) {
		if(!userService.isUserExist(userName)) {
			userService.addUser(userName, pwd);
		}else {
			System.out.println("重複的使用者名稱");
		}
		return "index";
	}
}
