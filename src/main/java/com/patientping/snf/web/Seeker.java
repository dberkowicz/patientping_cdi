package com.patientping.snf.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.patientping.snf.ejb.interfaces.PatientManager;

@Named("seeker")
@SessionScoped
public class Seeker implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String result;
	
	@EJB
	private PatientManager mPatientManager;
	
	public void findByHcin(String hcin){
		result =  mPatientManager.findPatientByHcin(hcin);
	}
	
	
	public String getResult(){
		return result;
	}
	
}
