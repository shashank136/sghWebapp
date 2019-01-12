package com.shgWebApp.project.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.shgWebApp.project.commands.WorkersForm;
import com.shgWebApp.project.model.Workers;

@Component
public class WorkersToWorkersForm implements Converter<Workers, WorkersForm>{

	@Override
	public WorkersForm convert(Workers workers) {
		
		WorkersForm workersForm = new WorkersForm();
		
		workersForm.setId(workers.getId());
		workersForm.setAadhaar(workers.getAadhaar());
		workersForm.setContact(workers.getContact());
		workersForm.setFirstname(workers.getFirstname());
		workersForm.setLastname(workers.getLastname());
		
		return workersForm;
	}

}
