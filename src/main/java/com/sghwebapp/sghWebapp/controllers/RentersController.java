package com.sghwebapp.sghWebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sghwebapp.sghWebapp.repositories.RentersRepositroy;

@Controller
public class RentersController {
	
	private RentersRepositroy rentersRepositroy;

	public RentersController(RentersRepositroy rentersRepositroy) {
		this.rentersRepositroy = rentersRepositroy;
	}
	
	@RequestMapping("/renters")
	public String getRenter(Model model) {
		model.addAttribute("renters", rentersRepositroy.findAll());
		return "renters";
	}
}
