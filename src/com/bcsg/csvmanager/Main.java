package com.bcsg.csvmanager;

import com.bcsg.csvmanager.controllers.CSVReader;
import com.bcsg.csvmanager.controllers.CardHolder;

public class Main {

	public static void main(String[] args) {
		final String csvName = "mid-test.csv";
		
		CSVReader csvReader = new CSVReader();
		CardHolder cardHolder = csvReader.read(csvName);
		
		cardHolder.maskCardsNumber();
		cardHolder.sortCards();
		cardHolder.displayCreditCard();
	}

}
