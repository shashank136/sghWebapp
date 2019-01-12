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
import com.shgWebApp.project.commands.RentersForm;
import com.shgWebApp.project.converters.RentersFormToRenters;
import com.shgWebApp.project.converters.RentersToRentersForm;
import com.shgWebApp.project.model.Owners;
import com.shgWebApp.project.model.Renters;
import com.shgWebApp.project.repositories.RentersRepository;

@Controller
public class RentersController {
	
	private RentersFormToRenters rentersFormToRenters;
	private RentersToRentersForm rentersToRentersForm;
	
	@Autowired
	public void setRentesToRentersForm(RentersToRentersForm rentersToRentersForm) {
		this.rentersToRentersForm = rentersToRentersForm;
	}
	
	@Autowired
	public void setRentersFormToRenters(RentersFormToRenters rentersFormToRenters) {
		this.rentersFormToRenters = rentersFormToRenters;
	}

	@Autowired
	RentersRepository rentersRepository;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/renters/form", method=RequestMethod.GET)
	public String rentersForm(Model model) {
		model.addAttribute("renters", new RentersForm());
		return "renterform";
	}
	
	@RequestMapping(value="/renters/form", method=RequestMethod.POST)
	public String renterSubmit(@ModelAttribute RentersForm renterForm, Model model) {
		
		Renters renter = rentersFormToRenters.convert(renterForm);
		
		model.addAttribute("renters", renter);
		String info = String.format("renter Submission: id = %d, firstname = %s, lastname = %s, ownername = %s, familysize = %s, address = %s, contact = %s",
				renter.getId(), renter.getFirstname(), renter.getLastname(), renter.getOwnername(), renter.getFamilysize(), renter.getAddress(), renter.getContact());
		
		log.info(info);
		
		rentersRepository.save(renter);
		
		return "renterresult";
	}
	
	@RequestMapping(value="/renters/edit", method=RequestMethod.GET)
    public String edit(@RequestParam("id") long id, Model model){
        
		Renters renter = rentersRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		RentersForm renterForm = rentersToRentersForm.convert(renter);

        model.addAttribute("renterForm", renterForm);
        return "editRenter";
    }
	
	@RequestMapping(value="/renters/load", method=RequestMethod.GET)
	public String renterSubmit(@RequestParam("id") long id, Model model) {
		
		Renters renter = rentersRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		model.addAttribute("renter", renter);
		return "renterload";
	}
	
	@RequestMapping("/renters")
	public String getOwner(Model model) {
		
		model.addAttribute("renters", rentersRepository.findAll());
		
		return "renters";
	}
}
