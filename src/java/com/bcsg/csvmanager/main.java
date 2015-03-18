package java.com.bcsg.csvmanager;

import java.com.bcsg.csvmanager.controllers.CSVReader;
import java.com.bcsg.csvmanager.controllers.CardHolder;

public class main {

	public static void main(String[] args) {
		final String csvName = "mid-test.csv";
		
		CSVReader csvReader = new CSVReader();
		CardHolder cardHolder = csvReader.read(csvName);
		
		cardHolder.maskCardsNumber();
		cardHolder.sortCards();
		cardHolder.displayCreditCard();
		
	}

}
