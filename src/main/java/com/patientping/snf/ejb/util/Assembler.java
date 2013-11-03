package com.patientping.snf.ejb.util;

import com.patientping.snf.ejb.entity.PatientEntity;
import com.patientping.snf.model.to.PatientTO;

public  class Assembler {

	public static PatientTO assemblePatientTO(PatientEntity p){
		PatientTO lp = new PatientTO();
		lp.setFirstName(p.getFirstName());
		lp.setLastName(p.getLastName());
		return lp;
	}
	
}
