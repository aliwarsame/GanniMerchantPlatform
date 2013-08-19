package com.gannimerchant.offers.dataaccess;

import java.util.List;

import com.gannimerchant.offers.domain.Merchant;
import com.gannimerchant.offers.domain.Offer;

public interface MerchantDataAccess {

	public abstract List<Merchant> findAll();
	public abstract List<Merchant> findBySurname(String surname);
	public abstract void insert(Merchant newMerchant);
	public abstract void insertOffer(Offer offer);
	public abstract List<Offer> findAllMerchantOffers(int id);

}