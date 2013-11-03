package com.patientping.snf.ejb.interfaces;

import com.patientping.snf.model.to.PatientTO;

public interface PatientManager {
	public PatientTO findPatientByHcin(String hcin);
	public PatientTO findPatientByFirstName(String firstName);
}
