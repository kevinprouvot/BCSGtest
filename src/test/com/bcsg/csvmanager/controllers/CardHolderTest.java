package test.com.bcsg.csvmanager.controllers;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bcsg.csvmanager.controllers.CardHolder;
import com.bcsg.csvmanager.models.CreditCard;

public class CardHolderTest {
	private CardHolder cardHolder;
	
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
	public void maskCardsNumberTest() {
		cardHolder = new CardHolder(unsortedCreditCards);
		cardHolder.maskCardsNumber();
		
		Assert.assertTrue("card number is not masked. Current : " + cardHolder.get(0).getNumber() ,
				HSBCCanadaMaskedNumber.equals(cardHolder.get(0).getNumber()));
		
		Assert.assertTrue("card number is not masked. Current : " + cardHolder.get(1).getNumber() ,
				RoyalBankCanadaMaskedNumber.equals(cardHolder.get(0).getNumber()));
		
		Assert.assertTrue("card number is not masked. Current : " + cardHolder.get(2).getNumber() ,
				AmericanExpress.equals(cardHolder.get(0).getNumber()));
		
	}
	
	@Test
	public void sortCardsTest() {
		cardHolder = new CardHolder(unsortedCreditCards);
		cardHolder.sortCards();
		
		Assert.assertTrue("cards are not correctly sorted",
				cardHolder.getCreditCards().get(0) == sortedCreditCards.get(0));

		Assert.assertTrue("cards are not correctly sorted",
				cardHolder.getCreditCards().get(1) == sortedCreditCards.get(1));

		Assert.assertTrue("cards are not correctly sorted",
				cardHolder.getCreditCards().get(2) == sortedCreditCards.get(2));
	}
	
	@Test
	public void displayCreditCardTest() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		final String SEPARATOR = " ";
		final String ENDLINE = "\\n";
		
		StringBuffer stringBuffer = new StringBuffer();
		for (CreditCard card : unsortedCreditCards) {
			stringBuffer.append(card.getBank());
			stringBuffer.append(SEPARATOR);
			stringBuffer.append(card.getNumber());
			stringBuffer.append(SEPARATOR);
			stringBuffer.append(card.getExpiryDate());
			stringBuffer.append(ENDLINE);
		}
		
		cardHolder = new CardHolder(unsortedCreditCards);
		cardHolder.displayCreditCard();
		Assert.assertTrue("Output is incorrent",
				stringBuffer.toString().equals(outContent));
		
		
		System.setOut(null);
	}

}
