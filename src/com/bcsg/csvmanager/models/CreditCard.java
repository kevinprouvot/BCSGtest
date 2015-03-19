package com.bcsg.csvmanager.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CreditCard {
	
	private String number;
	private Bank bank;
	private Date expiryDate;
	
	public static DateFormat dateFormat = new SimpleDateFormat("MMM-yyyy", Locale.ENGLISH);
	
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
	
	public Date getExpiryDate() {
		return expiryDate;
	}
	
	public String getExpiryDateAsString() {
		return CreditCard.dateFormat.format(expiryDate);
	}
	
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public void setExpiryDate(String expiryDateAsString) throws ParseException{
	    this.expiryDate = CreditCard.dateFormat.parse(expiryDateAsString);
	}
	
	public int getNumberLength() {
		return number.length();
	}
	
	@Override
	public String toString() {
		final Character SEPARATOR = ' ';
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(bank.toString());
		stringBuffer.append(SEPARATOR);
		stringBuffer.append(number);
		stringBuffer.append(SEPARATOR);
		stringBuffer.append(getExpiryDateAsString());
		
		return stringBuffer.toString();
	}
}
