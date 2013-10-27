package com.patientping.snf.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.patientping.snf.ejb.interfaces.PatientManager;

@Remote(PatientManager.class)
@Stateless
public class PatientManagerBean implements PatientManager{

	@Override
	public String findPatientByHcin(String hcin) {
		String result = "not found";
		if(hcin.equalsIgnoreCase("found"))
			result = "yes found";
		
		return result;
	}
	

}
