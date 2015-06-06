package nl.hkolvoort.euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	
	public static List<Integer> primeFactors(int numbers) {
	    int n = numbers;
	    List<Integer> factors = new ArrayList<Integer>();
	    for (int i = 2; i <= n / i; i++) {
	      while (n % i == 0) {
	        factors.add(i);
	        n /= i;
	      }
	    }
	    if (n > 1) {
	      factors.add(n);
	    }
	    return factors;
	  }
	
    public static ArrayList<Integer> findFactors(Integer num){
        int incrementer = 1;
        if (num % 2 != 0)
        {
            incrementer = 2; //only test the odd ones
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= num / 2; i=i+incrementer)
        {
            if (num % i == 0)
            {
                list.add(i);
            }
        }
        list.add(num);
        return list;
    }
    
    public static ArrayList<Integer> findFactors2(Integer num){
        int sqrt = (int) Math.sqrt(num);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= sqrt; i++)
        {
            if (num % i == 0)
            {
            	if (i != num/i){
	                list.add(i);
	                list.add(num/i);
            	}
            	else{
            		list.add(i);
            	}
            }
        }
        Collections.sort(list);
        return list;
    }
    
    public static Integer findFactorsFaster(Integer num){
        int nod = 0;
        int sqrt = (int) Math.sqrt(num);
        for (int i = 1; i <= sqrt ; i++)
        {
            if (num % i == 0)
            {
                nod += 2;
            }
        }
        if (sqrt * sqrt == num.intValue()){
        	nod -= 1;
        }
        return nod;
    }
    
	public static Integer calculateTriangle(Integer number){
		return (number * (number+1))/2;
	}
	
}
