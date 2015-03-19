package com.bcsg.csvmanager.models;

public class CreditCard {
	
	private String number;
	private Bank bank;
	private String expiryDate;
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public String getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	@Override
	public String toString() {
		final String SEPARATOR = " ";
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(bank.toString());
		stringBuffer.append(SEPARATOR);
		stringBuffer.append(number);
		stringBuffer.append(SEPARATOR);
		stringBuffer.append(expiryDate);
		
		return stringBuffer.toString();
	}
}
