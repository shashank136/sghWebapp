package com.sghwebapp.sghWebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sghwebapp.sghWebapp.repositories.OwnersRepository;

@Controller
public class OwnersController {
	
	private OwnersRepository ownersRepository;
	
	public OwnersController(OwnersRepository ownersRepository) {
		this.ownersRepository = ownersRepository;
	}

	@RequestMapping("/owners")
	public String getOwner(Model model) {
		
		model.addAttribute("owners", ownersRepository.findAll());
		
		return "owners";
	}
}
