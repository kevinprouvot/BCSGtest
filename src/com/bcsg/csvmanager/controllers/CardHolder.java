package com.bcsg.csvmanager.controllers;

import java.util.ArrayList;
import java.util.List;

import com.bcsg.csvmanager.exceptions.BankUnknownException;
import com.bcsg.csvmanager.models.CreditCard;

public class CardHolder {

	private List<CreditCard> creditCards;
	private List<CreditCard> unknowBankcards;
	
	private final Character DIGIT_SEPARATOR = '-';
	private final String MASKED_DIGIT = "x";
	
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
		switch(creditCard.getBank()) {
			case HSBC_CANADA :
				applyHSBCMask(creditCard);
			break;
			case ROYAL_BANK_OF_CANADA:
				applyRoyalBankOfCanadaMask(creditCard);
			break;
			case AMERICAN_EXPRESS:
				applyAmericanExpressMask(creditCard);
			break;
			default:
				throw new BankUnknownException();
		}
	}
	
	// 2 firsts digits
	private void applyHSBCMask(CreditCard creditCard) {		
		String cardNumber = creditCard.getNumber();
		StringBuffer maskedCardNumber = new StringBuffer();
		
		for (int index = 0 ; index < 2 ; index++) {
			maskedCardNumber.append(cardNumber.charAt(index));
		}
		
		for (int index = 2 ; index < cardNumber.length() ; index ++) {
			if (cardNumber.charAt(index) != DIGIT_SEPARATOR) {
				maskedCardNumber.append(MASKED_DIGIT);
			}
		}
		
		creditCard.setNumber(maskedCardNumber.toString());
	}
	
	// 4 firsts digits
	private void applyRoyalBankOfCanadaMask(CreditCard creditCard) {
		
	}
	
	// 3 lasts digits
	private void applyAmericanExpressMask(CreditCard creditCard) {
		
	}
	
	public void sortCards() {
		
	}
	
	public void displayCreditCard() {
		
	}
}
