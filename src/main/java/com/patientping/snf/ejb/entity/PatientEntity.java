package com.patientping.snf.ejb.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@NamedQueries({
	@NamedQuery(name=PatientEntity.BYFIRSTNAME, query="SELECT p FROM PatientEntity p WHERE p.firstName = :firstName")
	
})

@Entity
@Table(name="patient_entity")
@SuppressWarnings("serial")
public class PatientEntity implements Serializable{

	public static final String BYFIRSTNAME = "PatientEntity.byFirstName";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="patient")
	private Set<PatientIdentityEntity>identities;
	
	public Set<PatientIdentityEntity> getIdentities() {
		return identities;
	}
	public void setIdentities(Set<PatientIdentityEntity> identities) {
		this.identities = identities;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
