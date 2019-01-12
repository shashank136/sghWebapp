package com.shgWebApp.project.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.shgWebApp.project.commands.WorkersForm;
import com.shgWebApp.project.model.Workers;

@Component
public class WorkersFormToWorkers implements Converter<WorkersForm, Workers>{

	@Override
	public Workers convert(WorkersForm workersForm) {
		
		Workers workers = new Workers();
		if(workersForm.getId() != 0L && !StringUtils.isEmpty(workersForm.getId())) {
			workers.setId(workersForm.getId());
		}
		workers.setAadhaar(workersForm.getAadhaar());
		workers.setContact(workersForm.getContact());
		workers.setFirstname(workersForm.getFirstname());
		workers.setLastname(workersForm.getLastname());
		return workers;
	}	
	
}
