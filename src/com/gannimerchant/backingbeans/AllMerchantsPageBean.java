package com.gannimerchant.backingbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;

import com.gannimerchant.offers.MerchantManagementServiceLocal;
import com.gannimerchant.offers.domain.Merchant;
import com.gannimerchant.offers.domain.Offer;

@ManagedBean(name="allMerchantsPageBean")
public class AllMerchantsPageBean 
{
	private int id;
	
	@EJB
	private MerchantManagementServiceLocal merchantService;
	private Merchant selectedMerchant;
	private Offer selectedMerchantOffer;
	private UIData dataTable;	

	public List<Merchant> getAllMerchants()
	{
		return merchantService.getAllMerchants();
	}
	
	public List<Offer> getAllMerchantOffers()
	{
		String merchantId = FacesContext.getCurrentInstance().
				getExternalContext().getRequestParameterMap().get("merchantId");
		id = Integer.parseInt(merchantId);
		return merchantService.getAllMerchantOffers(id);
	}
	
	public String showAllMerchantOffers()
	{
		String merchantId = FacesContext.getCurrentInstance().
				getExternalContext().getRequestParameterMap().get("merchantId");
		id = Integer.parseInt(merchantId);
		merchantService.getAllMerchantOffers(id);
		return "allMerchantOffers";
	}
	
	public String showMerchant()
	{
		this.selectedMerchant = (Merchant)dataTable.getRowData();
		
		return "merchantDetail";
	}
	
	public String showMerchantOffers()
	{
		this.selectedMerchantOffer = (Offer)dataTable.getRowData();
		
		return "merchantOffersDetails";
	}
	
	public String createMerchantOffer()
	{
		this.selectedMerchant = (Merchant)dataTable.getRowData();
		
		return "enterNewOfferForm";
	}
	
	public Merchant getSelectedMerchant() {
		return selectedMerchant;
	}

	public void setSelectedMerchant(Merchant selectedMerchant) {
		this.selectedMerchant = selectedMerchant;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public Offer getSelectedMerchantOffer() {
		return selectedMerchantOffer;
	}

	public void setSelectedMerchantOffer(Offer selectedMerchantOffer) {
		this.selectedMerchantOffer = selectedMerchantOffer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
