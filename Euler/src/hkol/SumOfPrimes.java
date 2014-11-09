package hkol;

import java.util.ArrayList;

public class SumOfPrimes {
	private Long countPrimesTo;
	private ArrayList<Long> primeList;
	private Long result;
	
	public SumOfPrimes(Long input) {
		countPrimesTo = input;
		primeList = new ArrayList<Long>();
		fillPrimeArray();
		result = new Long(calculateSumOfPrimes());
	}
		
	public Long calculateSumOfPrimes(){
		Long tempResult = new Long(0);
		for (int i=0; i<primeList.size(); i++) {
			tempResult += primeList.get(i);
		}
		return tempResult;
	}
	
	private void fillPrimeArray() {
		for (Long i=(long) 0; i < countPrimesTo; i++ ) {
			if (isPrime(i)) {
				primeList.add(i);
			}
		}	
	}
	
	public Long getNumberOfPrimes() {
		return (long) primeList.size();
	}
	
	public String getFormattedResult() {
		String resultString = "";
		for (int i=0; i<primeList.size(); i++) {
			resultString += primeList.get(i);
			if (i<primeList.size()-1) {
				resultString += " + ";
			} else {
				resultString += " = ";
			}
		} 
		resultString += result;
		return resultString;
	}
	
	//checks whether a long is prime or not.
	//more info on http://en.wikipedia.org/wiki/Primality_test 
	public boolean isPrime(Long n) {
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

	public Long getResult() {
		return result;
	}
	
	
}
