package br.com.navita;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BiggestBrotherNumberTest {

	@Test
	public void validResult() {
		BiggestBrotherNumber biggestBrotherNumber = new BiggestBrotherNumber();
		
		int number = biggestBrotherNumber.getBiggestBrotherNumber("123");
		boolean validResult = number <= 100000000;
		
		assertTrue(validResult);
	}
	
	@Test
	public void invalidResult() {
		BiggestBrotherNumber biggestBrotherNumber = new BiggestBrotherNumber();
		
		int number = biggestBrotherNumber.getBiggestBrotherNumber("100010001");
		boolean validResult = number <= 100000000;
		
		assertFalse(validResult);
	}
}
