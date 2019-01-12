package com.shgWebApp.project.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.shgWebApp.project.commands.OwnersForm;
import com.shgWebApp.project.model.Owners;

@Component
public class OwnersToOwnersForm implements Converter<Owners, OwnersForm>{

	@Override
	public OwnersForm convert(Owners owners) {
		
		OwnersForm ownersForm = new OwnersForm();
		
		ownersForm.setId(owners.getId());
		ownersForm.setAddress(owners.getAddress());
		ownersForm.setContact(owners.getContact());
		ownersForm.setFamilysize(owners.getFamilysize());
		ownersForm.setFirstname(owners.getFirstname());
		ownersForm.setLastname(owners.getLastname());
		ownersForm.setSpousename(owners.getSpousename());
		ownersForm.setWelfarefeestatus(owners.getWelfarefeestatus());
		
		return ownersForm; 
	}

}
