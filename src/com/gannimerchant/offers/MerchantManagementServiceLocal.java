package com.gannimerchant.offers;

import java.util.List;

import javax.ejb.Local;

import com.gannimerchant.offers.domain.Merchant;
import com.gannimerchant.offers.domain.Offer;

@Local
public interface MerchantManagementServiceLocal 
{
	public void registerMerchant(Merchant newMerchant) throws SystemUnavailableException ;
	public void insertMerchantOffer(Offer offer);
	public List<Merchant> getAllMerchants();
	public List<Merchant> searchBySurname(String surname);
	public List<Offer> getAllMerchantOffers(int id);
}
