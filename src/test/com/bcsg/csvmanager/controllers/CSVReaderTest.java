package test.com.bcsg.csvmanager.controllers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bcsg.csvmanager.controllers.CSVReader;
import com.bcsg.csvmanager.controllers.CardHolder;
import com.bcsg.csvmanager.models.Bank;
import com.bcsg.csvmanager.models.CreditCard;

public class CSVReaderTest {
	
	private CSVReader csvReader;
	
	private final String csvName = "mid-test.csv";
	
	private CreditCard card1;
	private CreditCard card2;
	private CreditCard card3;
	private List<CreditCard> unsortedCreditCards;

	@Before
	public void setUp() throws Exception {
		csvReader = new CSVReader();
		
		card1 = new CreditCard();
		card1.setBank(Bank.HSBC_CANADA.toString());
		card1.setExpiryDate("Nov-2017");
		card1.setNumber("5601-2345-3446-5678");
		
		card2 = new CreditCard();
		card2.setBank(Bank.ROYAL_BANK_OF_CANADA.toString());
		card2.setExpiryDate("Oct-2017");
		card2.setNumber("4519-4532-4524-2456");
		
		card3 = new CreditCard();
		card3.setBank(Bank.AMERICAN_EXPRESS.toString());
		card3.setExpiryDate("Dec-2018");
		card3.setNumber("3786-7334-8965-345");
		
		unsortedCreditCards = new ArrayList<CreditCard>();
		unsortedCreditCards.add(card1);
		unsortedCreditCards.add(card2);
		unsortedCreditCards.add(card3);
	}

	@Test
	public void readTest() {
		CardHolder cardHolder = csvReader.read(csvName);
		
		Assert.assertTrue("Incorrect Size, : " + cardHolder.size(), 
				3 == cardHolder.size());
		
		Assert.assertTrue("Incorrect Card Information (Bank) : " + cardHolder.get(0).getBank(),
				card1.getBank().equals(cardHolder.get(0).getBank()));
		
		Assert.assertTrue("Incorrect Card Information (ExpiryDate) : " + cardHolder.get(0).getExpiryDate(),
				card1.getExpiryDate().equals(cardHolder.get(0).getExpiryDate()));
		
		Assert.assertTrue("Incorrect Card Information (Number) : " + cardHolder.get(0).getNumber(),
				card1.getNumber().equals(cardHolder.get(0).getNumber()));
	}

}
