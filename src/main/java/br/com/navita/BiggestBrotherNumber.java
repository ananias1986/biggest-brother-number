package br.com.navita;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.navita.utils.BrotherNumberComparator;
import br.com.navita.utils.BrotherNumberMessages;

/**
 * Class that show the biggest brother number 
 * 
 * @author Luiz Fernando Ananias
 */
public class BiggestBrotherNumber {
	
	private Scanner readNumber;

	public static void main(String[] args) {
		try {
			BiggestBrotherNumber biggestBrotherNumber = new BiggestBrotherNumber();
			biggestBrotherNumber.showBiggestBrotherNumber();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Show the biggest brother number
	 * 
	 * @throws Exception if result exceeded or invalid value
	 */
	private void showBiggestBrotherNumber() throws Exception {
		try {
			String number = getNumber();
			if (validateNumberLenght(number)) {
				throw new Exception(BrotherNumberMessages.resultExceeded);
			} else if (validatePositiveNumber(Integer.valueOf(number))) {
				throw new Exception(BrotherNumberMessages.invalidValue);
			} else {
				int biggestBrotherNumberValue = getBiggestBrotherNumber(number);
				if (validatePositiveNumber(biggestBrotherNumberValue)) {
					throw new Exception(BrotherNumberMessages.resultExceeded);
				} else {
					System.out.println("Biggest Brother Number: " + String.valueOf(biggestBrotherNumberValue));
				}
			}
		} catch (NumberFormatException e) {
			throw new Exception(BrotherNumberMessages.invalidValue);
		}
	}
	
	/**
	 * Return the number informed by user
	 * 
	 * @return the number informed by user 
	 */
	private String getNumber() {
		try {
			readNumber = new Scanner(System.in);
			
			System.out.println("Insert a number:");
			
			return readNumber.next();
		} catch (InputMismatchException e) {
			return "-1";
		}
	}
	
	/**
	 * Return the biggest brother number
	 * 
	 * @param number informed by user
	 * 
	 * @return the biggest brother number 
	 */
	public int getBiggestBrotherNumber(String number) {
		int brotherNumber = createBrotherNumber(number);
		if (!validateResult(brotherNumber)) {
			return -1;
		}
		
		return brotherNumber;
	}
	
	/**
	 * Invalidate if result is bigger that 100.000.000
	 * 
	 * @param number the result
	 * 
	 * @return true if valid, false if invalid
	 */
	private boolean validateResult(int number) {
		return number <= 100000000;
	}
	
	/**
	 * Validate if number informed is a positive number 
	 * 
	 * @param number informed by user
	 * 
	 * @result true if positive number, false if not positive number 
	 */
	private boolean validatePositiveNumber(int number) {
		return Integer.valueOf(number).intValue() < 0;
	}
	
	/**
	 * Validate the informed number lenght 
	 * 
	 * @param number informed by user
	 * 
	 * @result true if valid, false if invalid
	 */
	private boolean validateNumberLenght(String number) {
		return number.length() > 9 && number.matches("[2-9]+");
	}
	
	/**
	 * Create a brother number
	 * 
	 * @param number informed by user
	 * 
	 * @return the brother number created 
	 */
	private int createBrotherNumber(String number) {
		List<Integer> numberArray = new ArrayList<Integer>();
		
		for (int i = 0; i < number.length(); i++) {
			numberArray.add(Integer.valueOf(String.valueOf(number.charAt(i))));
		}
		
		Collections.sort(numberArray, new BrotherNumberComparator(false));
		
		number = "";
		for (Integer addNumber : numberArray) {
			number += addNumber;
		}

		return new Integer(number).intValue();
	}
}