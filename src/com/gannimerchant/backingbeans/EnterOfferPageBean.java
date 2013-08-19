package com.gannimerchant.backingbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.gannimerchant.offers.MerchantManagementServiceLocal;
import com.gannimerchant.offers.domain.Merchant;
import com.gannimerchant.offers.domain.Offer;

@ManagedBean(name="enterOffer")
public class EnterOfferPageBean {

	private int id;
	private String text;
	
	@EJB
	private MerchantManagementServiceLocal merchantService;
	
	public String createOffer()
	{
		String merchantId = FacesContext.getCurrentInstance().
				getExternalContext().getRequestParameterMap().get("merchantId");
		id = Integer.parseInt(merchantId);
		Offer newOffer = new Offer(text, id);

		merchantService.insertMerchantOffer(newOffer);
		return "all-merchants";
	
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
