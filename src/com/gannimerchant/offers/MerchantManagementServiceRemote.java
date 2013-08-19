package com.gannimerchant.offers;

import java.util.List;

import javax.ejb.Remote;

import com.gannimerchant.offers.domain.Merchant;

@Remote
public interface MerchantManagementServiceRemote 
{
	public void registerMerchant(Merchant newMerchant) throws SystemUnavailableException ;
	public List<Merchant> getAllMerchants();
	public List<Merchant> searchBySurname(String surname);
}
