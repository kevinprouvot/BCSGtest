package com.bcsg.csvmanager.controllers;

import java.util.ArrayList;
import java.util.List;

import com.bcsg.csvmanager.exceptions.BankUnknownException;
import com.bcsg.csvmanager.models.CreditCard;

public class CardHolder {

	private List<CreditCard> creditCards;
	private List<CreditCard> unknowBankcards;
	
	public CardHolder(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
		this.unknowBankcards = new ArrayList<CreditCard>();
	}
	
	public int size() {
		return creditCards.size();
	}
	
	public CreditCard get(int index) {
		return creditCards.get(index);
	}
	
	public List<CreditCard> getCreditCards() {
		return creditCards;
	}
	
	public void maskCardsNumber(){
		for(CreditCard creditCard : creditCards) {
			try {
				maskCardNumber(creditCard);
			}
			catch(BankUnknownException e) {
				unknowBankcards.add(creditCard);
			}
		}
		
		// Removing unknown credit cards from the cardHolder
		for(CreditCard creditCard : unknowBankcards) {
			if( creditCards.contains(creditCard)) {
				creditCards.remove(creditCard);
			}
		}
	}
	
	private void maskCardNumber(CreditCard creditCard) throws BankUnknownException{
		
	}
	
	public void sortCards() {
		
	}
	
	public void displayCreditCard() {
		
	}
}
