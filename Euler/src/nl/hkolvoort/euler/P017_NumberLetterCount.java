package nl.hkolvoort.euler;

/**
 * @author harm
 * @date 13-June-2015
 * 
 * Project Euler problem 17 Number Letter Counts
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, 
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written 
 * out in words, how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) 
 * contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
 * 
 * The use of "and" when writing out numbers is in compliance with British usage.
 */

public class P017_NumberLetterCount {

	private static final String[] tensNames = {
		"",
		"",
		"twenty",
		"thirty",
		"forty",
		"fifty",
		"sixty",
		"seventy",
		"eighty",
		"ninety"
	};
	private static final String[] numNames = {
		   "",
		    "one",
		    "two",
		    "three",
		    "four",
		    "five",
		    "six",
		    "seven",
		    "eight",
		    "nine",
		    "ten",
		    "eleven",
		    "twelve",
		    "thirteen",
		    "fourteen",
		    "fifteen",
		    "sixteen",
		    "seventeen",
		    "eighteen",
		    "nineteen"
	};
	private static final String thousand = "thousand";
	
	public static String convertNumberToWords(Integer number){
		StringBuilder convert = new StringBuilder(); 

		if (number > 1000){
			convert.append("Cannot proces numbers larger than thousand");
		}
		
		if (number < 0){
			convert.append("Cannot proces numbers less than zero");
		}		
		
		if (number == 1000){
			convert.append("one thousand");
		}
		
		if (number < 20 && number > 0){
			convert.append(numNames[number]);
		}
		
		if (number >=20 && number < 100){
			convert.append(tensNames[number / 10]);
			convert.append((number % 10 != 0) ? "-" : "");
			convert.append(numNames[number % 10]);
		}		
		
		if (number >=100 && number < 1000){
			convert.append(numNames[number / 100]);
			convert.append(" ");
			convert.append("hundred");
			convert.append((number % 100 != 0) ? " and " : "");
			convert.append(convertNumberToWords(number % 100));
		}	
		
		
		return convert.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(P017_NumberLetterCount.convertNumberToWords(1001));
		System.out.println(P017_NumberLetterCount.convertNumberToWords(1000));
		System.out.println(P017_NumberLetterCount.convertNumberToWords(0));
		System.out.println(P017_NumberLetterCount.convertNumberToWords(-1));
		
		Integer letters = 0;
		for (int i=1; i<=1000;i++){
			String strippedString = P017_NumberLetterCount.convertNumberToWords(i);
			strippedString = strippedString.replace(" ", "");
			strippedString = strippedString.replace("-", "");
			letters += strippedString.length();
			System.out.printf("count or letters sofar: %5d / ", letters );
			System.out.println(strippedString);
		}
		System.out.println("Total number of letters used: " + letters);
		
		
		
	}

}
