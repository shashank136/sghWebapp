package com.sghwebapp.sghWebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sghwebapp.sghWebapp.repositories.WorkersRepository;

@Controller
public class WorkersController {
	
	private WorkersRepository workersRepository;

	public WorkersController(WorkersRepository workersRepository) {
		this.workersRepository = workersRepository;
	}
	
	@RequestMapping("/workers")
	public String getWorker(Model model) {
		model.addAttribute("workers", workersRepository.findAll());
		return "workers";
	}
}
