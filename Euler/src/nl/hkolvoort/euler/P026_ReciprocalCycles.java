package nl.hkolvoort.euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Harm
 * @date 15-Aug-2015
 * 
 *	A unit fraction contains 1 in the numerator. 
 *	The decimal representation of the unit fractions 
 *	with denominators 2 to 10 are given:
 *	
 *	1/2	= 	0.5
 *	1/3	= 	0.(3)
 *	1/4	= 	0.25
 *	1/5	= 	0.2
 *	1/6	= 	0.1(6)
 *	1/7	= 	0.(142857)
 *	1/8	= 	0.125
 *	1/9	= 	0.(1)
 *	1/10	= 	0.1
 *	Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. 
 *	It can be seen that 1/7 has a 6-digit recurring cycle.
 *	
 *	Find the value of d < 1000 for which 1/d contains the longest 
 *	recurring cycle in its decimal fraction part.
 */



public class P026_ReciprocalCycles {
	
	private RecurringCycle recurringCycle;

	public P026_ReciprocalCycles(){
		recurringCycle = new RecurringCycle();
	}
	
	// works for denominators up till 1000
	public static boolean isTerminatingDecimal(Integer denominator){
		if (denominator <= 0 || denominator > 1000) throw new IllegalArgumentException("Denominator <= 0 or > 1000 not supported");
		
		if ((denominator > 0) && (denominator <= 10) && ((10 % denominator == 0) || (100 % denominator == 0) || (1000 % denominator == 0))){
			return true;
		}
		else if ((denominator > 10) && (denominator <= 100) && ((100 % denominator == 0 || (1000 % denominator == 0)))){
			return true;
		}
		else if ((denominator > 100) && (denominator <= 1000) && (1000 % denominator == 0)){
			return true;
		}
		else{
			return false;
		}
	}
	
	private boolean recurringNumerator(Integer numerator, List<Integer> numerators){
		if (numerators.contains(numerator)){
			return true;
		} 
		else{
			return false;
		}
	}
	
	public void longDivision(Integer numerator, Integer denominator){
		boolean isRepeatingNumerator = false;
		Integer originalDenominator = denominator;
		Integer remainder = 0;
		Integer division = 0;
		List<Integer> longDivisionDecimals = new ArrayList<Integer>();
		List<Integer> numerators = new ArrayList<Integer>();
		List<Integer> remainders = new ArrayList<Integer>();
			
		while (!isRepeatingNumerator){
			if (recurringNumerator(numerator, numerators)){
				isRepeatingNumerator = true;
				if (longDivisionDecimals.size() > recurringCycle.getLength()){
					recurringCycle.setDenominator(originalDenominator);
					recurringCycle.setLength(remainders.size()-1-remainders.indexOf(remainder));
					recurringCycle.setBeginPosition(remainders.indexOf(remainder));
					recurringCycle.setEndPosition(remainders.size()-2);
					recurringCycle.setRepeatingDecimals(longDivisionDecimals);
					System.out.println(recurringCycle.toString());
				}
			}
			else {
					division = numerator / denominator;
					remainder = numerator % denominator;
					numerators.add(numerator);
					remainders.add(remainder);
					longDivisionDecimals.add(division);
					System.out.println("denominator " + denominator.toString());
					System.out.println("numerators " + numerators.toString());
					System.out.println("remainders " + remainders.toString());
					System.out.println("decimals " + longDivisionDecimals.toString());
					numerator = remainder * 10;
				}
			}
		System.out.println();
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> repeatingDecimals = new ArrayList<Integer>();
			
		for (int i=1000; i>1; i--){
			if (!P026_ReciprocalCycles.isTerminatingDecimal(i)){
				repeatingDecimals.add(i);				
			}
		}
		
		P026_ReciprocalCycles p026 = new P026_ReciprocalCycles();
		p026.longDivision(1, 3);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1, 6);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1, 7);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1, 9);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,11);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,12);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,13);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,14);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,15);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,17);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,18);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,19);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,21);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,22);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,23);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,24);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,26);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,27);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,28);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,29);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,30);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,31);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,33);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,34);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,35);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,36);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,37);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,38);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,39);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,41);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,42);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,43);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,44);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,45);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,46);
		p026 = new P026_ReciprocalCycles();
		p026.longDivision(1,983);		
		
//		for (Integer i : repeatingDecimals){
//			p026.longDivision(1, i);
//		}
	}
}
       