package com.brian.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brian.entity.Vegetable;
import com.brian.service.VegetableService;

@Controller
public class HomeController {
	
	@Autowired
	private VegetableService vegService;
	
	@RequestMapping("/home")
	public String showAllVegetables(Model model, HttpSession session) {
		List<Vegetable> vegList = vegService.getAllVegetables();
		model.addAttribute("vegList", vegList);
		System.out.println(session.getAttribute("UID"));
		return "home";
	}
}
