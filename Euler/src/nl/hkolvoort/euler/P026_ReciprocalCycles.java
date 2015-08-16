package nl.hkolvoort.euler;

import java.util.ArrayList;
import java.util.List;

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
	
	public static String longDivision(Integer denominator){
		return "not yet implemented";
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> repeatingDecimals = new ArrayList<Integer>();
			
		for (int i=1; i<=1000; i++){
			if (!P026_ReciprocalCycles.isTerminatingDecimal(i)){
				repeatingDecimals.add(i);				
			}
		}
		
		System.out.println(repeatingDecimals);
	}

}
       