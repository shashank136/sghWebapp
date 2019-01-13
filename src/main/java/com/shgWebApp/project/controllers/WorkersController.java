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

import com.shgWebApp.project.commands.WorkersForm;
import com.shgWebApp.project.converters.WorkersFormToWorkers;
import com.shgWebApp.project.converters.WorkersToWorkersForm;
import com.shgWebApp.project.model.Workers;
import com.shgWebApp.project.repositories.WorkersRepository;

@Controller
public class WorkersController {
	
	private WorkersToWorkersForm workersToWorkersForm;
	private WorkersFormToWorkers workersFormToWorkers;
	
	@Autowired
	public void setWorkersToWorkersForm(WorkersToWorkersForm workersToWorkersForm) {
		this.workersToWorkersForm = workersToWorkersForm;
	}
	
	@Autowired
	public void setWorkersFormToWorkers(WorkersFormToWorkers workersFormToWorkers) {
		this.workersFormToWorkers = workersFormToWorkers;
	}
	
	@Autowired
	WorkersRepository workersRepository;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/workers/form", method=RequestMethod.GET)
	public String workersForm(Model model) {
		model.addAttribute("workers", new WorkersForm());
		return "workers/workerform";
	}
	
	@RequestMapping(value="/workers/form", method=RequestMethod.POST)
	public String workerSubmit(@ModelAttribute WorkersForm workerForm, Model model) {
		
		Workers worker = workersFormToWorkers.convert(workerForm);
		
		model.addAttribute("workers", worker);
		String info = String.format("worker Submission: id = %d, firstname = %s, lastname = %s, aadhaar = %s, contact = %s",
				worker.getId(), worker.getFirstname(), worker.getLastname(), worker.getAadhaar(), worker.getContact());
		
		log.info(info);
		
		workersRepository.save(worker);
		
		return "workers/workerresult";
	}
	
	@RequestMapping(value="/workers/edit", method=RequestMethod.GET)
    public String edit(@RequestParam("id") long id, Model model){
        
		Workers worker = workersRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		WorkersForm workerForm = workersToWorkersForm.convert(worker);

        model.addAttribute("workerForm", workerForm);
        return "workers/editWorker";
    }
	
	@RequestMapping(value="/workers/load", method=RequestMethod.GET)
	public String workerSubmit(@RequestParam("id") long id, Model model) {
		
		Workers worker = workersRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		model.addAttribute("worker", worker);
		return "workers/workerload";
	}
	
	@RequestMapping("/workers")
	public String getOwner(Model model) {
		
		model.addAttribute("workers", workersRepository.findAll());
		
		return "workers/workers";
	}

}
