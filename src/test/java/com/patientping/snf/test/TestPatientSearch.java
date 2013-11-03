package com.patientping.snf.test;

import javax.ejb.EJB;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.patientping.snf.ejb.PatientManagerBean;
import com.patientping.snf.ejb.entity.PatientEntity;
import com.patientping.snf.ejb.entity.PatientIdentityEntity;
import com.patientping.snf.ejb.interfaces.PatientManager;
import com.patientping.snf.ejb.util.Assembler;
import com.patientping.snf.util.DateAdapter;

import edu.patientping.snf.model.to.PatientTO;

@RunWith(Arquillian.class)
public class TestPatientSearch {

	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap
				.create(WebArchive.class, "testMojo.war")
				.addClasses(PatientManager.class, PatientManagerBean.class)
				.addClasses(PatientEntity.class, PatientIdentityEntity.class)
				.addClasses(PatientTO.class)
				.addClasses(Assembler.class, DateAdapter.class)
				.addAsResource("META-INF/test-persistence.xml","META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

	}
	
	@EJB
	private PatientManager mBean;
	
	@Test
	public void testSearchByFirstName(){
		String firstName = "david";
		PatientTO result = mBean.findPatientByFirstName(firstName);
		Assert.assertEquals("Name should match", result.getLastName(), new String("Berkowicz"));
	}
	
	@Test
	public void testFindByHCIN(){
		String lastName = "Berkowicz";
		String hcin = "hcin1234";
		PatientTO result = mBean.findPatientByHcin(hcin);
		Assert.assertEquals(result.getLastName(), lastName);
	}
}
