package nl.hkolvoort.euler;

import java.util.ArrayList;

/**
 * @author Harm Kolvoort
 * @date 13-5-2015
 * 
 * Problem 4: Largest palindrome product
 * A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * 
 */

public class P4_LargestPalindromeProduct {

	private ArrayList<Integer> palindromes;
		
	/**
	 * Constructor: create empty ArrayList palindromes
	 */
	public P4_LargestPalindromeProduct(){
		this.palindromes = new ArrayList<Integer>();
	}
	
	public Integer getReverseNumber(int input){
		StringBuffer reverseString = new StringBuffer(String.valueOf(input));
		reverseString.reverse();
		System.out.println(Integer.parseInt(reverseString.toString()));
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
	
	public static void main(String[] args){
        P4_LargestPalindromeProduct p4 = new P4_LargestPalindromeProduct();
        System.out.println(p4.getReverseNumber(9091));
        System.out.println(p4.isPalindrome(9008));
        System.out.println(p4.isPalindrome(9009));
        System.out.println(p4.isPalindrome(1111));
    }

	public Integer getLargestPalindrome() {
		// TODO Auto-generated method stub
		return null;
	}
}
