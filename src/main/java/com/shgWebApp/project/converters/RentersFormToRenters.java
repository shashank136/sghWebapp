package com.shgWebApp.project.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.shgWebApp.project.commands.RentersForm;
import com.shgWebApp.project.model.Renters;

@Component
public class RentersFormToRenters implements Converter<RentersForm, Renters>{

	@Override
	public Renters convert(RentersForm rentresForm) {
		
		Renters renters = new Renters();
		
		if(rentresForm.getId() != 0L && !StringUtils.isEmpty(rentresForm.getId())) {
			renters.setId(rentresForm.getId());
		}
		renters.setAddress(rentresForm.getAddress());
		renters.setContact(rentresForm.getContact());
		renters.setFamilysize(rentresForm.getFamilysize());
		renters.setFirstname(rentresForm.getFirstname());
		renters.setLastname(rentresForm.getLastname());
		renters.setOwnername(rentresForm.getOwnername());
		return renters;
	}

}
