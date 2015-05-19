package nl.hkolvoort.euler;

import java.util.ArrayList;

/**
 * @author Harm
 * @date 19-May-2015
 * 
 * Problem 3: 10001st Prime
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10001st prime number?
 * 
 */
public class P007_10001stPrime {
	private ArrayList<Long> primes;
	
	
	public P007_10001stPrime(){
		primes = new ArrayList<Long>();
	}
	
	public void fillPrimes(){
		Integer count = 0;
		Long number = new Long(2);
		
		while (count<=10001){
			if (PrimeHelper.isPrime(number)){
				primes.add(count, number);
				count++;
			}
			number++;
		}
	}
	
	public Long getPrimeAtIndex(Integer index){
		return primes.get(index);
	}

	public static void main(String[] args) {

		P007_10001stPrime p7 = new P007_10001stPrime();
		p7.fillPrimes();
		System.out.println("The 10001st prime is: " + p7.getPrimeAtIndex(10000));
	}

}
