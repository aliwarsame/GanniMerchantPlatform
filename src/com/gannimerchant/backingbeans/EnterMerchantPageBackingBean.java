package com.gannimerchant.backingbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.gannimerchant.offers.MerchantManagementServiceLocal;
import com.gannimerchant.offers.SystemUnavailableException;
import com.gannimerchant.offers.domain.Merchant;

@ManagedBean(name="enterMerchant")
public class EnterMerchantPageBackingBean 
{
	private String firstName;
	private String surname;
	private String jobRole;
	private int salary;
	private int id;
	
	@EJB
	private MerchantManagementServiceLocal merchantService;
	
	public String createMerchant()
	{
		Merchant newMerchant = new Merchant(firstName, surname, jobRole, salary);
		
		try 
		{
			merchantService.registerMerchant(newMerchant);
			return "all-merchants";
		} 
		catch (SystemUnavailableException e) 
		{
			return "systemDown";
		}
		
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
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


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	

}
