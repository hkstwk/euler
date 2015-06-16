package nl.hkolvoort.euler;

import java.math.BigInteger;

/**
 * @author Harm
 * @date 13-June_2015
 * 
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class p025_ThousandDigitFibonacci {

	public static final BigInteger getThousandDigitFibonacci(){
		BigInteger index = new BigInteger("3"); // index is set at 3 initially
		BigInteger fib1 = new BigInteger("1");  // index 1
		BigInteger fib2 = new BigInteger("1");  // index 2
		BigInteger fib = new BigInteger("2");   // index 3
		Integer digits = fib.toString().length();
		
		while (digits < 1000){
			fib1 = fib2;
			fib2 = fib;
			fib = fib1.add(fib2);
			index = index.add(new BigInteger("1"));
			System.out.println("Index " + index.toString() + ": " + fib1.toString() 
								+ " + " + fib2.toString() + " = " + fib.toString());
			if (fib.toString().length() > digits){
				digits++;
			}
		}
		
		return index;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Index = " + p025_ThousandDigitFibonacci.getThousandDigitFibonacci());

	}

}
