package hkol;

import java.util.ArrayList;

/**
 * @author Harm
 * @date 14-11-2014
 * 
 * Problem 2: Even Fibonacci numbers
 * 
 * Each new term in the Fibonacci sequence is generated 
 * by adding the previous two terms. 
 * 
 * By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * 
 * By considering the terms in the Fibonacci sequence 
 * whose values do not exceed four million, 
 * find the sum of the even-valued terms.
 */
public class P2_SumOfEvenFibonacci {
	private Integer sum;
	private Integer limit;	
	
	/**
	 * Constructor sets sum to zero. 
	 */
	public P2_SumOfEvenFibonacci() {
		sum = 0;
		limit = 0;
		fibonacciList = new ArrayList<Integer>();
	}

	private ArrayList<Integer> fibonacciList;
	
	/**
	 * Constructor sets sum to zero. 
	 */
	public P2_SumOfEvenFibonacci(Integer lim) {
		sum = 0;
		limit = lim;
		fibonacciList = new ArrayList<Integer>();
	}

	/**
	 * Returns true if fib is an even (fibonacci) number, else false
	 * Example 1: 5 will return false
	 * Example 2: 34 will return true
	 * @param fib
	 * @return
	 */
	public boolean isEvenFibonacci(int fib) {
		if (fib % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * method to fill fibonacci list till limit 
	 * limit for this exercise is 4 million. 
	 * Can be any positive number however
	 */
	public void fillFibonacciList() {
		// Helper array to store last 2 fibonacci numbers
		// after adding new entry, delete the first one
		ArrayList<Integer> twoFibs = new ArrayList<Integer>();
		twoFibs.add(1);
		twoFibs.add(2);
		
		// Populate list with first two fibonacci numbers
		fibonacciList.add(1);
		fibonacciList.add(2);
		
		Integer nextFib = 0;
		while (nextFib < this.limit) {
			// Sum the last two Fibs to get the next
			nextFib = twoFibs.get(0) + twoFibs.get(1);
			
			// Add nextFib to helper Array; 
			// Delete oldest from helper Array
			twoFibs.add(nextFib);
			twoFibs.remove(0);
			
			// Add nextFib to the fibonacci sequence
			fibonacciList.add(nextFib);
		}
	}
	
	/**
	 * recursive method to fill fibonacci list till limit 
	 * limit for this exercise is 4 million. 
	 * Can be any positive number however
	 */
	public void fillFibonacciListRecursive() {
		// Helper array to store last 2 fibonacci numbers
		// after adding new entry, delete the first one
		ArrayList<Integer> twoFibs = new ArrayList<Integer>();
		twoFibs.add(1);
		twoFibs.add(2);
		
		// Populate list with first two fibonacci numbers
		fibonacciList.add(1);
		fibonacciList.add(2);
		
		Integer nextFib = 0;
		while (nextFib < limit) {
			// Sum the last two Fibs to get the next
			nextFib = twoFibs.get(0) + twoFibs.get(1);
			
			// Add nextFib to helper Array; 
			// Delete oldest from helper Array
			twoFibs.add(nextFib);
			twoFibs.remove(0);
			
			// Add nextFib to the fibonacci sequence
			fibonacciList.add(nextFib);
		}
	}	
	
	public void sumEvenFibonacciNumbers() {
		for (int i=0; i<fibonacciList.size();i++) {
			if (isEvenFibonacci(fibonacciList.get(i))) {
				sum += fibonacciList.get(i);
			}
		}
	}

	public Integer getSumEvenFibonacci() {
		return sum;
	}
	
	
	public ArrayList<Integer> getFibonacciList() {
		return fibonacciList;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	

}
