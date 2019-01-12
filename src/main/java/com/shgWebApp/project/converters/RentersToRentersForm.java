package com.shgWebApp.project.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.shgWebApp.project.commands.RentersForm;
import com.shgWebApp.project.model.Renters;

@Component
public class RentersToRentersForm implements Converter<Renters, RentersForm>{

	@Override
	public RentersForm convert(Renters renters) {
		
		RentersForm rentersForm = new RentersForm();
		
		rentersForm.setId(renters.getId());
		rentersForm.setAddress(renters.getAddress());
		rentersForm.setContact(renters.getContact());
		rentersForm.setFamilysize(renters.getFamilysize());
		rentersForm.setFirstname(renters.getFirstname());
		rentersForm.setLastname(renters.getLastname());
		rentersForm.setOwnername(renters.getOwnername());
		
		return rentersForm;
	}

}
