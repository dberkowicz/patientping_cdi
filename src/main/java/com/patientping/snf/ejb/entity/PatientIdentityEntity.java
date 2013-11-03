package com.patientping.snf.ejb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries({
	@NamedQuery(name=PatientIdentityEntity.BYSCHEMEVALUE, query="SELECT i FROM PatientIdentityEntity i WHERE i.identityScheme = :scheme AND i.identityValue = :value")
	
})


@Entity
@Table(name="patient_identity_entity")
public class PatientIdentityEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	public static final String BYSCHEMEVALUE = "PatientIdentityEntity.bySchemeValue";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="identity_scheme")
	private String identityScheme;
	
	@Column(name="identity_value")
	private String identityValue;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="patient_id")
	private PatientEntity patient;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentityScheme() {
		return identityScheme;
	}

	public void setIdentityScheme(String identityScheme) {
		this.identityScheme = identityScheme;
	}

	public String getIdentityValue() {
		return identityValue;
	}

	public void setIdentityValue(String identityValue) {
		this.identityValue = identityValue;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}
	
}
