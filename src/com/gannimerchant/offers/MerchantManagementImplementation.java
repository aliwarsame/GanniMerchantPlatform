package com.gannimerchant.offers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.gannimerchant.offers.dataaccess.MerchantDataAccess;
import com.gannimerchant.offers.domain.Merchant;
import com.gannimerchant.offers.domain.Offer;

@Stateless
public class MerchantManagementImplementation 
    implements MerchantManagementServiceRemote, MerchantManagementServiceLocal {

	@EJB
	private MerchantDataAccess dao;
	private int id;

	public List<Merchant> getAllMerchants() 
	{
		return dao.findAll();
	}

	public List<Offer> getAllMerchantOffers(int id) 
	{
		return dao.findAllMerchantOffers(id);
	}
	
	public void registerMerchant(Merchant newMerchant) throws SystemUnavailableException 
	{
		dao.insert(newMerchant);
	}

	public void insertMerchantOffer(Offer offer) 
	{
		dao.insertOffer(offer);
	}
	
	public List<Merchant> searchBySurname(String surname) {
		return dao.findBySurname(surname);
	}	
}
