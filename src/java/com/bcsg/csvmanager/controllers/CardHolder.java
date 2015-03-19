package java.com.bcsg.csvmanager.controllers;

import java.com.bcsg.csvmanager.models.CreditCard;
import java.util.List;

public class CardHolder {

	private List<CreditCard> creditCards;
	
	public CardHolder(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
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
	
	public void maskCardsNumber() {
		
	}
	
	public void sortCards() {
		
	}
	
	private void maskCardNumber(CreditCard creditCard) {
		
	}
	
	public void displayCreditCard() {
		
	}
}
