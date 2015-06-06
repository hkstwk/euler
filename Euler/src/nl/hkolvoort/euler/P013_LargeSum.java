package nl.hkolvoort.euler;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author harm
 * @date 6-June-2015
 * 
 * Project Euler, Problem 13 Large Sum
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 * 
 */
public class P013_LargeSum {
	
	private ArrayList<BigInteger> bigInts;
	private BigInteger sumOfBigInts;
	
	public P013_LargeSum(String fileName) throws FileNotFoundException{
		bigInts = new ArrayList<BigInteger>();
		loadNumbers(fileName);
		sumOfBigInts = getSumOfBigInts();
	}
	
	public void loadNumbers(String fileName) throws FileNotFoundException{
	    // create Scanners 
	    Scanner fileScanner = new Scanner(new File(fileName));
	    
	    // while loop for file scanner. Continue till last line.
	    while (fileScanner.hasNextLine()){
	    	bigInts.add(new BigInteger(fileScanner.nextLine()));
	    }
	    fileScanner.close();
	  }
	
	public BigInteger getSumOfBigInts(){
		BigInteger bint = new BigInteger("0");
		for (int i=0; i< this.bigInts.size(); i++){
			bint = bint.add(bigInts.get(i));
		}
		return bint;
	}
	
	public String getFirstTenDigits(){
		return sumOfBigInts.toString().substring(0, 10);
	}
	
	public String toString(){
		return "Sum of one hundred 50 digit numbers is: " 
				+ sumOfBigInts.toString()
				+ "\nThe first 10 digits are "
				+ getFirstTenDigits();		
	}
	
	

	public static void main(String[] args) throws FileNotFoundException {
		P013_LargeSum p013 = new P013_LargeSum("/Users/harm/Documents/Eclipse/P013_euler.txt");
		System.out.println(p013.toString());
	}

}
