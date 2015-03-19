package com.bcsg.csvmanager.models;

public enum Bank {
	HSBC_CANADA("HSBC Canada"),
	ROYAL_BANK_OF_CANADA("Royal Bank of  Canada"),
	AMERICAN_EXPRESS("American Express"),
	UNKNOWN_BANK("Unknow Bank");
	
	private String name = "";
	
	Bank(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
