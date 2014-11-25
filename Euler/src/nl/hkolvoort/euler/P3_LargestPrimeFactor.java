package nl.hkolvoort.euler;

import java.util.ArrayList;

/**
 * @author Harm
 * @date 25-Nov-2014
 * 
 * Problem 3: Largest Prime Factor
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143
 * 
 */
public class P3_LargestPrimeFactor {
	private ArrayList<Long> primeList;
	private Long input; 
	
	public P3_LargestPrimeFactor(Long input) {
		this.primeList = PrimeHelper.fillPrimeArray(input);
		this.input = input;
	}
	
	public Long calcLargestPrimeFactor() {
		Long lpf = new Long(0);
		for (int i=0; i<this.primeList.size(); i++) {
			if (input % this.primeList.get(i) == 0 && this.primeList.get(i) > lpf)
				lpf = this.primeList.get(i);
		} 
		return (long) lpf;
	}
	
	public ArrayList<Long> getPrimeList() {
		return this.primeList;
	}

	
}
