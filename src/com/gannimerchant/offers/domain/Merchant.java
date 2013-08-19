package com.gannimerchant.offers.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Merchant implements java.io.Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String firstName;
	private String surname;
	private String jobRole;
	private int salary;
//	
//	@OneToMany(cascade=CascadeType.PERSIST)
//	@JoinColumn(name="fk_merchant_id")
//	private Set<Offer> offers;
	
	public Merchant() 
	{
		// required by JPA, but not used by us.
	}
		
	public Merchant(String firstName, String surname, String jobRole, int salary) 
	{
		super();
		//this.offers = new HashSet<Offer>();
		this.firstName = firstName;
		this.surname = surname;
		this.jobRole = jobRole;
		this.salary = salary;
	}

	public String toString()
	{
		return "Merchant " + this.firstName + " " + this.surname;
	}
	
	public void setSurname(String newName)
	{
		this.surname = newName;
	}
	
//	public void addOffer(Offer newOffer)
//	{
//		//Offer newOffer = new Offer(newOfferText);
//		this.offers.add(newOffer);
//	}

//	public Set<Offer> getAllNotes() 
//	{
//		return this.offers;
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getSurname() {
		return surname;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
