package test.com.bcsg.csvmanager;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bcsg.csvmanager.Main;
import com.bcsg.csvmanager.models.CreditCard;

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
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		final String SEPARATOR = " ";
		final String ENDLINE = "\\n";
		
		StringBuffer stringBuffer = new StringBuffer();
		for (CreditCard card : sortedAndMaskedCreditCards) {
			stringBuffer.append(card.getBank());
			stringBuffer.append(SEPARATOR);
			stringBuffer.append(card.getNumber());
			stringBuffer.append(SEPARATOR);
			stringBuffer.append(card.getExpiryDate());
			stringBuffer.append(ENDLINE);
		}
		
		Main.main(new String[1]);
		
		Assert.assertTrue("Output is incorrent",
				stringBuffer.toString().equals(outContent));		
		
		System.setOut(null);
	}

}
