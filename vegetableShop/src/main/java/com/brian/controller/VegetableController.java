package com.brian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brian.entity.Vegetable;
import com.brian.service.VegetableService;

@Controller
public class VegetableController {
	
	@Autowired
	private VegetableService vegService;
	
	@RequestMapping(value = "/vegetable", method = RequestMethod.POST)
	public String addVeg(Vegetable veg) {
		vegService.updateVeg(veg);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/vegetable/{id}", method = RequestMethod.GET)
	public String toUpdateVeg(@PathVariable("id") int vegId, Model model) {
		Vegetable veg = vegService.getVeg(vegId);
		model.addAttribute("vegetable", veg);
		return "updateVeg";
	}
	
	@RequestMapping(value = "/vegetable", method = RequestMethod.PUT)
	public String updateVeg(Vegetable veg) {
		vegService.updateVeg(veg);
		return "redirect:/home";
	}
}
