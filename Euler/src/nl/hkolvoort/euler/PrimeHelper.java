package nl.hkolvoort.euler;

import java.util.ArrayList;

public class PrimeHelper {

	//checks whether a long is prime or not.
	//more info on http://en.wikipedia.org/wiki/Primality_test 
	public static boolean isPrime(Long n) {
		if (n <= 3) {
	        return n > 1;
	    } else if (n % 2 == 0 || n % 3 == 0) {
	        return false;
	    } else {
	        for (Integer i = 5; i * i <= n; i += 6) {
	            if (n % i == 0 || n % (i + 2) == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	}
	
	public static ArrayList<Long> fillPrimeArray(Long countPrimesTo) {
		ArrayList<Long> primeList = new ArrayList<Long>();
		for (Long i=(long) 0; i < countPrimesTo; i++ ) {
			if (PrimeHelper.isPrime(i)) {
				primeList.add(i);
			}
		}
		return primeList;
	}
	
	public static Long calculateSumOfPrimes(ArrayList<Long> primeList){
		Long SumOfPrimes = new Long(0);
		for (int i=0; i<primeList.size(); i++) {
			SumOfPrimes += primeList.get(i);
		}
		return SumOfPrimes;
	}
	
	public static Long getNumberOfPrimes(ArrayList<Long> primeList) {
		return (long) primeList.size();
	}
	
}
