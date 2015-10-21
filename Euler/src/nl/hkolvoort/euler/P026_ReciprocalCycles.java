package nl.hkolvoort.euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Harm
 * @date 15-Aug-2015
 * 
 * ProjectEuler.net problem 26 - Reciprocal cycles	
 * 
 * A terminating decimal is a decimal number that has digits that do not go on forever.
 *	like 1/4 = 0,25 
 *  and 1/8 = 0,125
 *	
 *	A Recurring decimal is a decimal number that has digits that repeat forever.
 *	like 1/3 = 0,333... (the 3 repeats forever) 
 *  and 1/7 = 0,142857142857...  (the recurring cycle "142857" repeats forever)
 * 
 *	Find the value of d < 1000 for which 1/d contains the longest 
 *	recurring cycle in its decimal fraction part.
 */



public class P026_ReciprocalCycles {
	
	private RecurringCycle longestRecurringCycle;
	
	private boolean isNotRepeatingNumerator;
	private Integer originalDenominator;
	private Integer numerator;
	private Integer remainder;
	private Integer division;
	private List<Integer> longDivisionDecimals;
	private List<Integer> numerators;
	private List<Integer> remainders;

	public P026_ReciprocalCycles(){
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
			if (P026_ReciprocalCycles.fractionIsRecurringDecimal(i)){
				repeatingDecimals.add(i);				
			}
		}
		
		P026_ReciprocalCycles p026 = new P026_ReciprocalCycles();
		for (Integer i : repeatingDecimals){
			p026.longDivision(i);
		}
		
		System.out.println(p026.longestRecurringCycle.toString());
	}
}
       