package nl.hkolvoort.euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Corners are constantly increasing by +2, constantly adding the value to previous corner
 * 
 * spiral 1   has 1 corner (one member)
 * spiral 3x3 has 5 (1 + 4) corners
 * spiral 5x5 has 9 (1 + 4 + 4) corners
 * spiral 7x7 has 13 (1 + 4 + 4 + 4) corners
 * spiral nxn has (n-1) / 2 (only odd numbers) * 4 (# corners) +1 (center) corners
 * spiral 1001x1001 has (((1001-1)/2)*4) + 1= 2001 corners
 * 
 * Corner values can be determined by following algorithm
 *  increment = 2 // initial value
 *  corner[1] = corner[0] + increment (2); increment += 2
 *  corner[2] = corner[0] + increment (4); increment += 2
 *  corner[3] = corner[0] + increment (6); increment += 2
 *  corner[4] = corner[0] + increment (8); increment += 2
 *  corner[5] = corner[5-4] + increment (10); increment += 2
 *  ....
 *  corner[2001] = corner[2001-4] + increment
 * 
 * Summing diagonally from top left to bottom right means 
 * summing corners 1, 2, 4, 6, 8, 10, ..., 2000
 * 
 */


public class P028_SpiralDiagonals {
	
	private RecurringCycle longestRecurringCycle;
	
	private boolean isNotRepeatingNumerator;
	private Integer originalDenominator;
	private Integer numerator;
	private Integer remainder;
	private Integer division;
	private List<Integer> longDivisionDecimals;
	private List<Integer> numerators;
	private List<Integer> remainders;

	public P028_SpiralDiagonals(){
		longestRecurringCycle = new RecurringCycle();
	}
	
	public static boolean fractionIsRecurringDecimal(Integer denominator){
		/*  
		 If the prime factorization of the denominator of a fraction has only factors of 2 and factors of 5, 
		 the decimal expression terminates.  If there is any prime factor in the denominator other than 2 or 5, 
		 then the decimal expression is recurring.  
		 */
		
		Set<Integer> primeFactorSet = new HashSet<Integer>(EulerHelper.primeFactors(denominator));
		return !(primeFactorSet.size() == 2 && primeFactorSet.contains(2) && primeFactorSet.contains(5));
		}
	
	public void longDivision(Integer denominator){
		initializeLongDivisonFields(denominator);
			
		while (noRepeatingNumeratorFound()){
			if (numeratorWasAlreadyUsed(numerator)){
				repeatingNumeratorFound();
				if (recurringCycleLengthIsGreaterThanCurrentMaximumLength()){
					updateLongestRecurringCycle();
				}
			}
			else {
					doNextDivision(numerator, denominator);
					addNumeratorToListOfNumerators(numerator);
					addRemainderToListOfRemainders(remainder);
					addDivisionToListOfDecimals(division);
					determineNextNumerator(remainder);
				}
			}
	}
	
	private boolean noRepeatingNumeratorFound(){
		return isNotRepeatingNumerator;
	}

	private void repeatingNumeratorFound(){
		isNotRepeatingNumerator = false;
	}
	private boolean numeratorWasAlreadyUsed(Integer numerator){
		if (numerators.contains(numerator)){
			return true;
		} 
		else{
			return false;
		}
	}
	
	private boolean recurringCycleLengthIsGreaterThanCurrentMaximumLength(){
		return longDivisionDecimals.size() > longestRecurringCycle.getLength();
	}
	
	private void initializeLongDivisonFields(Integer denominator){
		isNotRepeatingNumerator = true;
		originalDenominator = denominator;
		numerator = 1;
		remainder = 0;
		division = 0;
		longDivisionDecimals = new ArrayList<Integer>();
		numerators = new ArrayList<Integer>();
		remainders = new ArrayList<Integer>();
	}

	private void updateLongestRecurringCycle() {
		longestRecurringCycle.setDenominator(originalDenominator);
		longestRecurringCycle.setLength(remainders.size()-1-remainders.indexOf(remainder));
		longestRecurringCycle.setBeginPosition(remainders.indexOf(remainder));
		longestRecurringCycle.setEndPosition(remainders.size()-2);
		longestRecurringCycle.setRepeatingDecimals(longDivisionDecimals);
	}
	
	private void doNextDivision(Integer numerator, Integer denominator){
		division = numerator / denominator;
		remainder = numerator % denominator;
	} 
	
	private void addNumeratorToListOfNumerators(Integer numerator){
		numerators.add(numerator);
	}
	
	private void addRemainderToListOfRemainders(Integer remainder){
		remainders.add(remainder);
	}
	
	private void addDivisionToListOfDecimals(Integer division){
		longDivisionDecimals.add(division);
	}
	
	private void determineNextNumerator(Integer remainder){
		numerator = remainder * 10;
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> repeatingDecimals = new ArrayList<Integer>();
			
		for (int i=1000; i>1; i--){
			if (P028_SpiralDiagonals.fractionIsRecurringDecimal(i)){
				repeatingDecimals.add(i);				
			}
		}
		
		P028_SpiralDiagonals p026 = new P028_SpiralDiagonals();
		for (Integer i : repeatingDecimals){
			p026.longDivision(i);
		}
		
		System.out.println(p026.longestRecurringCycle.toString());
	}
}
       