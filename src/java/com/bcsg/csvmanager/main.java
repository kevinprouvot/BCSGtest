package java.com.bcsg.csvmanager;

import java.com.bcsg.csvmanager.controllers.CSVReader;
import java.com.bcsg.csvmanager.controllers.CardManager;

public class main {

	public static void main(String[] args) {
		final String csvName = "mid-test.csv";
		
		CSVReader csvReader = new CSVReader();
		CardManager cardManager = new CardManager();
		
		cardManager.setCreditCards(csvReader.read(csvName));
		cardManager.maskAllCardNumber();
		cardManager.sortCards();
		cardManager.displayCreditCard();
		
	}

}
