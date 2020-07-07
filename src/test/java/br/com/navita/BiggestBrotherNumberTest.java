package br.com.navita;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BiggestBrotherNumberTest {

	@Test
	public void validResult() {
		int result = 100000001;
		
		assertTrue(result <= 100000000);
	}
}
