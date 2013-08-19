package com.gannimerchant.offers.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.gannimerchant.offers.domain.Merchant;
import com.gannimerchant.offers.domain.Offer;

@Stateless
public class MerchantDataAccessImplementation implements MerchantDataAccess
{	
	@PersistenceContext
	private EntityManager em;

	public List<Merchant> findAll() {		
		Query q = em.createQuery("select merchant from Merchant merchant");		
		List<Merchant> results = q.getResultList();
		return results;
	}

	public List<Merchant> findBySurname(String surname) {
		Query q = em.createQuery("select merchant from Merchant merchant where merchant.surname = :surname");
		q.setParameter("surname", surname);
		return q.getResultList();
	}

	public void insert(Merchant newMerchant) {
		em.persist(newMerchant);	
	}
	
	public void insertOffer(Offer offer){
		em.persist(offer);
	}

	public List<Offer> findAllMerchantOffers(int merchantId) {		
		Query q = em.createQuery("select offer from Offer offer where offer.fk_merchant = :merchantId");
		q.setParameter("merchantId", merchantId);
		List<Offer> results = q.getResultList();
		return results;
	}
	
}
