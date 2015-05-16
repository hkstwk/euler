package nl.hkolvoort.euler;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Harm Kolvoort
 * @date 13-5-2015
 * 
 * Problem 4: Largest palindrome product
 * A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 * 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * 
 */

public class P4_LargestPalindromeProduct {

	private ArrayList<Integer> palindromes;
	public static final boolean DEBUG = true;
	public static final boolean NODEBUG = false;
		
	/**
	 * Constructor: create empty ArrayList palindromes
	 */
	public P4_LargestPalindromeProduct(){
		this.palindromes = new ArrayList<Integer>();
	}
	
	public Integer getReverseNumber(int input){
		StringBuffer reverseString = new StringBuffer(String.valueOf(input));
		reverseString.reverse();
		//System.out.println(Integer.parseInt(reverseString.toString()));
		return Integer.parseInt(reverseString.toString().trim());
	}
	
	public boolean isPalindrome(Integer input){
		if (input.equals(getReverseNumber(input))){
			return true;
		}
		else{
			return false;
		}	
	}
	
	public void findPalindromes(int startValue, int endValue, boolean debug){
		for (int i=startValue; i<endValue; i++){
			for (int j=startValue; j<=i;j++){
				if (debug){
					System.out.print(i*j + " ");
				}
				if (isPalindrome(i*j)){
					this.palindromes.add(i*j);
				}
			}
			if (debug){
				System.out.println();
			}
		}
		Collections.sort(this.palindromes);
		System.out.println(this.palindromes);
	}
	
	public Integer getLargestPalindrome() {
		if (this.palindromes.isEmpty()){
			return -1;
		}
		return Collections.max(this.palindromes);
	}
	
	public static void main(String[] args){
        P4_LargestPalindromeProduct p4 = new P4_LargestPalindromeProduct();
        System.out.println("Maximum Palindrome is: " + p4.getLargestPalindrome());
        p4.findPalindromes(100,1000,NODEBUG);
        System.out.println("Maximum Palindrome is: " + p4.getLargestPalindrome());
    }
}
