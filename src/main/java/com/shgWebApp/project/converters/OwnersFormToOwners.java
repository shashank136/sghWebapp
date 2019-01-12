package com.shgWebApp.project.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.shgWebApp.project.commands.OwnersForm;
import com.shgWebApp.project.model.Owners;

@Component
public class OwnersFormToOwners implements Converter<OwnersForm, Owners>{

	@Override
	public Owners convert(OwnersForm ownersForm) {
		
		Owners owners = new Owners();		
		if(ownersForm.getId() != 0L && !StringUtils.isEmpty(ownersForm.getId())) {
			owners.setId(ownersForm.getId());
		}
		
		owners.setAddress(ownersForm.getAddress());
		owners.setContact(ownersForm.getContact());
		owners.setFamilysize(ownersForm.getFamilysize());
		owners.setFirstname(ownersForm.getFirstname());
		owners.setLastname(ownersForm.getLastname());
		owners.setSpousename(ownersForm.getSpousename());
		owners.setWelfarefeestatus(ownersForm.getWelfarefeestatus());
		
		return owners;
	}

}
