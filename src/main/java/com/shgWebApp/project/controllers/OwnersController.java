package com.shgWebApp.project.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shgWebApp.project.commands.OwnersForm;
import com.shgWebApp.project.converters.OwnersFormToOwners;
import com.shgWebApp.project.converters.OwnersToOwnersForm;
import com.shgWebApp.project.model.Owners;
import com.shgWebApp.project.repositories.OwnersRepository;

@Controller
public class OwnersController {
	
	private OwnersToOwnersForm ownersToOwnersForm;
	private OwnersFormToOwners ownersFormToOwners;
	
	@Autowired
	public void setOwnersFormToOwners(OwnersFormToOwners ownersFormToOwners) {
		this.ownersFormToOwners = ownersFormToOwners;
	}
	
	@Autowired
	public void setOwnersToOwnersForm(OwnersToOwnersForm ownersToOwnersForm) {
		this.ownersToOwnersForm = ownersToOwnersForm;
	}
	
	@Autowired
	OwnersRepository ownersRepository;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/owners/form", method=RequestMethod.GET)
	public String ownersForm(Model model) {	// give out the form for owners registration.
		model.addAttribute("owners", new OwnersForm());
		return "owners/form";
	}
	
	@RequestMapping(value="/owners/form", method=RequestMethod.POST)
	public String ownerSubmit(@ModelAttribute OwnersForm ownersForm, Model model) { // obtains the results from the form and save the details in the db
		
		Owners owner = ownersFormToOwners.convert(ownersForm);
		
		model.addAttribute("owners", owner);
		String info = String.format("Owner Submission: id = %d, firstname = %s, lastname = %s, spousename = %s, familysize = %s, address = %s, contact = %s, welfarefeestatus = %s",
				owner.getId(), owner.getFirstname(), owner.getLastname(), owner.getSpousename(), owner.getFamilysize(), owner.getAddress(), owner.getContact(), owner.getWelfarefeestatus());
		
		log.info(info);
		
		ownersRepository.save(owner);
		
		return "owners/result";
	}
	
	@RequestMapping(value="/owners/edit", method=RequestMethod.GET)
    public String edit(@RequestParam("id") long id, Model model){ //edit the owner's details
        
		Owners owner = ownersRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		OwnersForm ownersForm = ownersToOwnersForm.convert(owner);

        model.addAttribute("ownersForm", ownersForm);
        return "owners/editOwner";
    }
	
	@RequestMapping(value="/owners/load", method=RequestMethod.GET)
	public String ownerSubmit(@RequestParam("id") long id, Model model) { // fetch the details of a single user on demand 
		
		Owners owner = ownersRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		model.addAttribute("owner", owner);
		return "owners/load";
	}
	
	@RequestMapping("/owners")
	public String getOwner(Model model) { // get all the owners details
		
		model.addAttribute("owners", ownersRepository.findAll());
		
		return "owners/owners";
	}
}

