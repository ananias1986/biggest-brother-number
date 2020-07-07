package br.com.navita.utils;

import java.util.Comparator;

public class BrotherNumberComparator implements Comparator<Integer> {
	boolean ascendingOrder = true;
    
    public BrotherNumberComparator(boolean ascendingOrder) {
        this.ascendingOrder = ascendingOrder;
    }
    
    public int compare(Integer brotherNumber1, Integer brotherNumber2) {
    	int number1 = brotherNumber1.intValue();
    	int number2 = brotherNumber2.intValue();
    	
    	if (ascendingOrder) {
            return number1 < number2 ? -1 : (number1 > number2 ? +1 : 0);
        } else {
        	return number1 < number2 ? +1 : (number1 > number2 ? -1 : 0);
        }
    }
}