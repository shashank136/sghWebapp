package com.sghwebapp.sghWebapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sghwebapp.sghWebapp.model.Owners;
import com.sghwebapp.sghWebapp.model.Renters;
import com.sghwebapp.sghWebapp.model.Workers;
import com.sghwebapp.sghWebapp.repositories.OwnersRepository;
import com.sghwebapp.sghWebapp.repositories.RentersRepositroy;
import com.sghwebapp.sghWebapp.repositories.WorkersRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private OwnersRepository ownersRepository;
	private RentersRepositroy rentersRepository;
	private WorkersRepository workersRepository;	
	
	public DevBootstrap(OwnersRepository ownersRepository, RentersRepositroy rentersRepository,
			WorkersRepository workersRepository) {
		this.ownersRepository = ownersRepository;
		this.rentersRepository = rentersRepository;
		this.workersRepository = workersRepository;
	}

	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		intiDate();
	}
	
	private void intiDate() {
		
		// Demo data
		
		// Owners
		Owners mohan = new Owners("Mohan", "Kumar", "Jyothi", "9999624749", 4, true, true, "Plot No.69");
		Owners shashank = new Owners("Shashank", "Kumar", "none", "7032473030", 1, true, false, "Plot No.999");
		
		ownersRepository.save(mohan);
		ownersRepository.save(shashank);
		
		// Workers
		Workers balamma = new Workers("Balamma", "", "9998887770", "SOME_AADHAAR");
		
		workersRepository.save(balamma);
		
		// Renters
		Renters venkat = new Renters("Venkat", "Kulkarni", "1234567890", "Plot No.123", 8000);
		
		rentersRepository.save(venkat);
	}

}
