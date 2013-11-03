package com.patientping.snf.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.patientping.snf.ejb.interfaces.PatientManager;
import com.patientping.snf.model.to.PatientTO;

@Named("seeker")
@SessionScoped
public class Seeker implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private PatientTO result;
	
	@EJB
	private PatientManager mPatientManager;
	
	public void findByHcin(String hcin){
		result =  mPatientManager.findPatientByHcin(hcin);
	}
	
	
	public PatientTO getResult(){
		return result;
	}
	
}
