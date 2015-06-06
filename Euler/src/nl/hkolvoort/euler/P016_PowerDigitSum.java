package nl.hkolvoort.euler;

import java.math.BigInteger;

/**
 * @author harm
 * @date 6-June-2015
 * 
 * Project Euler, Problem 13 Large Sum
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 * 
 */
public class P016_PowerDigitSum {
	
	private BigInteger power;
	private Integer pow;
	
	public P016_PowerDigitSum(Integer pow){
		power = powerOfTwo(pow);
		this.pow = pow;
	}
	
	public BigInteger powerOfTwo(Integer pow){
		BigInteger bint = new BigInteger("2");
		return bint.pow(pow);
	}
	
	public String getPower(){
		return power.toString();
	}
	
	public String getSumOfDigits(){
		Integer sum = 0;
		String powerString = power.toString();
		
		for (int i=0; i< powerString.length(); i++){
			sum += Integer.parseInt(String.valueOf((powerString.charAt(i))));
		}
		
		return sum.toString();
	}
	
	public String toString(){
		return "2 power " 
				+ pow + " = " + getPower()
				+ "\nNumber of digits is " + power.toString().length()
				+ "\nSum of those digits is " + getSumOfDigits();
	}
	
	

	public static void main(String[] args) {
		System.out.println(new P016_PowerDigitSum(1000).toString());
	}

}
