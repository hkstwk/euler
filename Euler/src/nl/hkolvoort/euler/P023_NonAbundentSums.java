package nl.hkolvoort.euler;

import java.util.ArrayList;

/**
 * @author harm
 * @date 28-June-2015
 * 
 * Project Euler, Problem 23 Non-abundent sums
 * 
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. 
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum 
 * of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can 
 * be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even 
 * though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 * 
 */
public class P023_NonAbundentSums {

	public static final Integer limit = 28123;
	
	public static Integer sumOfProperDivisors(Integer number){
		ArrayList<Integer> properDivisors = EulerHelper.getProperDivisors(number);
		return EulerHelper.sumOfArrayList(properDivisors);
	}
	
	public static ArrayList<Integer> getAbundantNumbers(Integer limit){
		// only process positive integers 1 and higher
		if (limit <= 0){
			return null;
		}
		
		ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();
		Integer sum = 0;
		for (int i=1; i<=limit; i++){
			System.out.print("n = " + i + " ; ");
			System.out.print("sum of proper divisors of \"" + i + "\" = ");
			sum = P023_NonAbundentSums.sumOfProperDivisors(i);
			System.out.print(sum);
			if (sum == i){
				System.out.println(" perfect number");
			} else if (sum < i){
				System.out.println(" deficient number");
			} else if (sum > i){
				System.out.println(" abundant number");
				abundantNumbers.add(i);
			}
		}
		return abundantNumbers;
	}
	
	public static ArrayList<Integer> getAbundantSums(ArrayList<Integer> abundantNumbers){
		ArrayList<Integer> abundantSums = new ArrayList<Integer>();
		
		for (int i=0; i<abundantNumbers.size();i++){
			for (int j=i; j<abundantNumbers.size(); j++){
				Integer sum = abundantNumbers.get(i)+abundantNumbers.get(j);
				if ((sum < limit) && !abundantSums.contains(sum)){
					//System.out.println(sum);
					abundantSums.add(sum);					
				}
			}
		}
		abundantSums.sort(null);
		return abundantSums;
	}
	
	public static Integer getSolution(ArrayList<Integer> abundantSums){
		Integer sum = 0;
		for (int i=0; i<limit;i++){
			if(!abundantSums.contains(i)){
				sum += i;
			}
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		System.out.println(sumOfProperDivisors(28));
		System.out.println(getSolution(getAbundantSums(getAbundantNumbers(limit))));
	}

}
