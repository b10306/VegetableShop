package com.brian.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brian.dao.UserDAO;
import com.brian.entity.User;
import com.brian.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(String userName, String pwd, Model model, HttpSession session) {
		if(userService.isUserExist(userName)) {
			if(userService.isPwdCorrect(userName, pwd)) {
				User user = userService.getUser(userName, pwd);
				session.setAttribute("UID", user.getId());
				session.setAttribute("role", user.getRole());
				return "redirect:/home";
			}else {
				model.addAttribute("info", "密碼錯誤");
			}
		}else {
			model.addAttribute("info", "用戶不存在");
		}
		return "forward:/";
	}
}
