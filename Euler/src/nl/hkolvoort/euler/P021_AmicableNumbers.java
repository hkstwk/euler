package nl.hkolvoort.euler;

import java.util.ArrayList;

/**
 * @author harm
 * @date 16-June-2015
 * 
 * Problem 21 Amicable numbers
 *
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 */
public class P021_AmicableNumbers {
	
	public static void main(String[] args) {
		ArrayList<Integer> amicableNumbers = new ArrayList<Integer>();
		
		for (int i=1; i<10000; i++){
			ArrayList<Integer> divisors1 = EulerHelper.getProperDivisors(i);
			Integer sumDivisors1 = EulerHelper.sumOfArrayList(divisors1);
			Integer sumDivisors2 = EulerHelper.sumOfArrayList(EulerHelper.getProperDivisors(sumDivisors1));
			if ((sumDivisors2.intValue() == i) && (sumDivisors1.intValue() != i)){
				if (!amicableNumbers.contains(i)){
					amicableNumbers.add(i);
					amicableNumbers.add(sumDivisors1);
				}
			}
		}
		System.out.println(amicableNumbers);
		System.out.println(EulerHelper.sumOfArrayList(amicableNumbers));
	}

}
