package com.patientping.snf.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.patientping.snf.ejb.entity.PatientEntity;
import com.patientping.snf.ejb.entity.PatientIdentityEntity;
import com.patientping.snf.ejb.interfaces.PatientManager;
import com.patientping.snf.ejb.util.Assembler;
import com.patientping.snf.model.to.PatientTO;

@Remote(PatientManager.class)
@Stateless
public class PatientManagerBean implements PatientManager{

	private final String HCIN_SCHEME = "hcin";
	
	@PersistenceContext(unitName = "patientping_PU")
	private EntityManager mEntityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public PatientTO findPatientByHcin(String hcin) {
		PatientTO result = null;
		Query lQuery = mEntityManager.createNamedQuery(PatientIdentityEntity.BYSCHEMEVALUE);
		lQuery.setParameter("value", hcin);
		lQuery.setParameter("scheme", HCIN_SCHEME);
		
		List<PatientIdentityEntity>lList = lQuery.getResultList();
		if(lList.size() > 0){
			PatientEntity lPatient = lList.get(0).getPatient();
			result = Assembler.assemblePatientTO(lPatient);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public PatientTO findPatientByFirstName(String name){
		PatientTO result = null;
		Query lQuery = mEntityManager.createNamedQuery(PatientEntity.BYFIRSTNAME);
		lQuery.setParameter("firstName", name);
		
		List<PatientEntity>lList = lQuery.getResultList();
		if(lList.size() > 0){
			PatientEntity lPatient = lList.get(0);
			result = Assembler.assemblePatientTO(lPatient);
		}
		return result;
	}

}
