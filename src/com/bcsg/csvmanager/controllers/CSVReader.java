package com.bcsg.csvmanager.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bcsg.csvmanager.models.CreditCard;


public class CSVReader {
	
	private final String CSV_SEPARATOR = ",";
	
	/**
	 * The read method return a cardHolder from a CSV file
	 * CSF file must be in the current directory
	 * @param name of the CSV file
	 * @return cardHolder
	 */
	public CardHolder read(String fileName) {
		final String fileFullPath = getFilePath(fileName);
		
		List<CreditCard> creditCards = new ArrayList<CreditCard>();
		BufferedReader bufferedReader = null;
		String line = "";
		
		try {
			bufferedReader = new BufferedReader(new FileReader(fileFullPath));
			while ((line = bufferedReader.readLine()) != null) {
				CreditCard card = new CreditCard();
				String[] cardInformation = line.split(CSV_SEPARATOR);
				
				card.setBank(cardInformation[0]);
				card.setNumber(cardInformation[1]);
				card.setExpiryDate(cardInformation[2]);
				creditCards.add(card);
			}
		}
		catch(Exception e) {
			System.out.println("[error] on " + this.getClass() + " : ");
			e.printStackTrace();
		}
		finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					System.out.println("[Error] on closing bufferedReader : ");
					e.printStackTrace();
				}
			}
		}
		
		CardHolder cardHoler = new CardHolder(creditCards);
		
		return cardHoler;
	}
	
	private String getFilePath(String fileName) {
		StringBuffer stringBuffer = new StringBuffer(System.getProperty("user.dir"));
		stringBuffer.append(File.separator);
		stringBuffer.append(fileName);
		
		return stringBuffer.toString();
	}
}
