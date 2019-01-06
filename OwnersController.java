package com.shgWebApp.sghWebapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shgWebApp.project.model.Owners;
import com.shgWebApp.project.repositories.OwnersRepository;

@Controller
public class OwnersController {
	
	@Autowired
	OwnersRepository ownersRepository;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/owners/form", method=RequestMethod.GET)
	public String ownersForm(Model model) {
		model.addAttribute("owners", new Owners());
		return "form";
	}
	
	@RequestMapping(value="/owners/form", method=RequestMethod.POST)
	public String ownerSubmit(@ModelAttribute Owners owner, Model model) {
		
		model.addAttribute("owners", owner);
		String info = String.format("Owner Submission: id = %d, firstname = %s, lastname = %s, spousename = %s, familysize = %s, address = %s, contact = %s, welfarefeestatus = %s",
				owner.getId(), owner.getFirstname(), owner.getLastname(), owner.getSpousename(), owner.getFamilysize(), owner.getAddress(), owner.getContact(), owner.getWelfarefeestatus());
		
		log.info(info);
		
		ownersRepository.save(owner);
		
		return "result";
	}
	
	@RequestMapping(value="/owners/load", method=RequestMethod.GET)
	public String ownerSubmit(@RequestParam("id") long id, Model model) {
		
		Owners owner = ownersRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		model.addAttribute("owner", owner);
		return "load";
	}
	
	@RequestMapping("/owners")
	public String getOwner(Model model) {
		
		model.addAttribute("owners", ownersRepository.findAll());
		
		return "owners";
	}
}

