package test.com.bcsg.csvmanager.controllers;

import static org.junit.Assert.*;

import java.com.bcsg.csvmanager.models.CreditCard;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CardHolderTest {
	private CreditCard card1;
	private String HSBCCanadaMaskedNumber;
	private CreditCard card2;
	private String RoyalBankCanadaMaskedNumber;
	private CreditCard card3;
	private String AmericanExpress;
	private List<CreditCard> unsortedCreditCards;
	private List<CreditCard> sortedCreditCards;

	@Before
	public void setUp() throws Exception {
		card1 = new CreditCard();
		card1.setBank("HSBC Canada");
		card1.setExpiryDate("Nov-2017");
		card1.setNumber("5601-2345-3446-5678");
		HSBCCanadaMaskedNumber = "56xx-xxxx-xxxx-xxxx";
		
		card2 = new CreditCard();
		card2.setBank("Royal Bank of  Canada");
		card2.setExpiryDate("Oct-2017");
		card2.setNumber("4519-4532-4524-2456");
		RoyalBankCanadaMaskedNumber = "4519-xxxx-xxxx-xxxx";
		
		card3 = new CreditCard();
		card3.setBank("American Express");
		card3.setExpiryDate("Dec-2018");
		card3.setNumber("3786-7334-8965-345");
		AmericanExpress = "xxxx-xxxx-xxxx-345";
		
		unsortedCreditCards = new ArrayList<CreditCard>();
		unsortedCreditCards.add(card1);
		unsortedCreditCards.add(card2);
		unsortedCreditCards.add(card3);
		
		sortedCreditCards = new ArrayList<CreditCard>();
		sortedCreditCards.add(card3);
		sortedCreditCards.add(card1);
		sortedCreditCards.add(card2);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
