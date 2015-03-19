package com.bcsg.csvmanager.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bcsg.csvmanager.exceptions.BankUnknownException;
import com.bcsg.csvmanager.models.CreditCard;

public class CardHolder {

	private List<CreditCard> creditCards;
	private List<CreditCard> unknowBankcards;
	
	private final Character DIGIT_SEPARATOR = '-';
	private final Character MASKED_DIGIT = 'x';
	
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
	
	// 2 firsts digits are not masked
	private void applyHSBCMask(CreditCard creditCard) {		
		applyMaskAt(creditCard, 2, creditCard.getNumberLength());
	}
	
	// 4 firsts digits are not masked
	private void applyRoyalBankOfCanadaMask(CreditCard creditCard) {
		applyMaskAt(creditCard, 4, creditCard.getNumberLength());
	}
	
	// 3 lasts digits are not masked
	private void applyAmericanExpressMask(CreditCard creditCard) {
		int numberLenght = creditCard.getNumberLength();

		applyMaskAt(creditCard, 0, numberLenght - 4);
	}
	
	/**
	 * Mask the character from a card number from startDigit to endDigit.
	 * endDigit is not masked.
	 * If you want to mask the end of a card number, intDigit should be equals to cardNumber.lenght()
	 * @param creditCard Mask will be apply on this creditCard number
	 * @param startDigit starting digit. Index of this digit will be masked
	 * @param endDigit ending Digit. Index - 1 of this digit will be masked
	 */
	private void applyMaskAt(CreditCard creditCard, int startDigit, int endDigit) {
		String cardNumber = creditCard.getNumber();
		StringBuffer maskedCardNumber = new StringBuffer();
		
		for (int index = 0 ; index < startDigit ; index++) {
			maskedCardNumber.append(cardNumber.charAt(index));
		}
		for (int index = startDigit ; index < endDigit ; index++) {
			if (cardNumber.charAt(index) != DIGIT_SEPARATOR) {
				maskedCardNumber.append(MASKED_DIGIT);
			}
			else {
				maskedCardNumber.append(DIGIT_SEPARATOR);
			}
		}
		for (int index = endDigit ; index < cardNumber.length() ; index++) {
			maskedCardNumber.append(cardNumber.charAt(index));
		}
		
		creditCard.setNumber(maskedCardNumber.toString());
	}
	
	/**
	 * Sort credit cards
	 * Ordered by Expiry date in descending order.
	 */
	public void sortCards() {
		Collections.sort(creditCards);
	}
	
	public void displayCreditCard() {
		for(CreditCard creditCard : creditCards) {
			System.out.println(creditCard.toString());
		}
	}
}
