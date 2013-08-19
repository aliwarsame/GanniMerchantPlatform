package com.gannimerchant.offers.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Offer
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private String text;
    private int fk_merchant;
    
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	public Offer()
	{
		
	}

	public Offer(String text, int fk_merchant)
	{
		this.date = new java.util.Date();
		this.text = text;
		this.fk_merchant = fk_merchant;
	}

	public String toString()
	{
		return "Offer created at " + this.date + " with contents " + this.text;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getFk_merchant() {
		return fk_merchant;
	}

	public void setFk_merchant(int fk_merchant) {
		this.fk_merchant = fk_merchant;
	}
}
