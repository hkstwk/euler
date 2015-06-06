package nl.hkolvoort.euler;

import java.math.BigInteger;

/**
 * @author harm
 * @date 6-June-2015
 * 
 * Project Euler, Problem 20 Factorial Digit Sum
 * 
 */
public class P020_FactorialDigitSum {
	
	private BigInteger factorial;
	private Integer n;
	
	public P020_FactorialDigitSum(Integer n){
		factorial = getFactorial(n);
		this.n = n;
	}
	
	public BigInteger getFactorial(Integer n){
		BigInteger fact = new BigInteger(n.toString());
		Integer nextN = n-1;
		for (int i=n; i>1; i--){
			fact = fact.multiply(new BigInteger(nextN.toString())); 
			nextN -= 1;
		}
		return fact;
	}
	
	public String getFactorial(){
		return factorial.toString();
	}
	
	public String getSumOfDigits(){
		Integer sum = 0;
		String factorialString = factorial.toString();
		
		for (int i=0; i< factorialString.length(); i++){
			sum += Integer.parseInt(String.valueOf((factorialString.charAt(i))));
		}
		
		return sum.toString();
	}
	
	public String toString(){
		return n + "! = " + getFactorial()
				+ "\nNumber of digits is " + factorial.toString().length()
				+ "\nSum of those digits is " + getSumOfDigits();
	}
	
	

	public static void main(String[] args) {
		System.out.println(new P020_FactorialDigitSum(100).toString());
	}

}
