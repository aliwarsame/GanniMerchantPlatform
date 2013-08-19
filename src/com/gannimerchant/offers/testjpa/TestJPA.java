package com.gannimerchant.offers.testjpa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.gannimerchant.offers.domain.Merchant;
import com.gannimerchant.offers.domain.Offer;

public class TestJPA {

	
	
public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ganniMerchantPlatform");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
				
		//Merchant merchant = em.find(Merchant.class, 301);
		//merchant.setId(12);
		Merchant merchant = new Merchant();
		merchant.setFirstName("Ali");
		merchant.setSurname("warsame");
		merchant.setJobRole("consul");
		merchant.setSalary(111);
		em.persist(merchant);
		
		Offer offer = new Offer();
		
		
		offer.setText("Buy one get ten free");
		em.persist(offer);
		
		
		//merchant.addOffer(offer);
		
		
		
		tx.commit();
		em.close();

	}

}
