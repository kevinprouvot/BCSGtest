package test.com.bcsg.csvmanager;

import static org.junit.Assert.*;

import java.com.bcsg.csvmanager.models.CreditCard;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class mainTest {

	private CreditCard card1;
	private CreditCard card2;
	private CreditCard card3;
	private List<CreditCard> sortedAndMaskedCreditCards;

	@Before
	public void setUp() throws Exception {
		card1 = new CreditCard();
		card1.setBank("HSBC Canada");
		card1.setExpiryDate("Nov-2017");
		card1.setNumber("56xx-xxxx-xxxx-xxxx");
		
		card2 = new CreditCard();
		card2.setBank("Royal Bank of  Canada");
		card2.setExpiryDate("Oct-2017");
		card2.setNumber("4519-xxxx-xxxx-xxxx");
		
		card3 = new CreditCard();
		card3.setBank("American Express");
		card3.setExpiryDate("Dec-2018");
		card3.setNumber("xxxx-xxxx-xxxx-345");

		sortedAndMaskedCreditCards = new ArrayList<CreditCard>();
		sortedAndMaskedCreditCards.add(card3);
		sortedAndMaskedCreditCards.add(card1);
		sortedAndMaskedCreditCards.add(card2);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
