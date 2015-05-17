package nl.hkolvoort.euler;

/**
 * @author Harm Kolvoort
 * @date 17-05-2015
 * 
 * Problem 5: Smallest Multiple
 * 
 * 2520 is the smallest number that can be divided by each 
 * of the numbers from 1 to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible 
 * by all of the numbers from 1 to 20?
 * 
 * Defined couple of groups. If divisible by first number of group, then divisible by all in group
 * This saves 50% of checks to find to Smallest Multiple
 * Group 20, 10, 5, 4, 2, 1
 * Group 19 (prime)
 * Group 18, 9, 6, 3, 2, 1
 * Group 17 (prime)
 * Group 16, 8, 4, 2, 1
 * Group 15, 5, 3, 1
 * Group 14, 7, 1
 * Group 13 (prime)
 * Group 12, 6, 4, 3, 2, 1
 * Group 11 (prime)
 *
 *
 */
public class P005_SmallestMultiple {
	private Integer smallestMultiple;
	
	/**
	 * Constructor sets sum to zero. 
	 */
	public P005_SmallestMultiple() {
		smallestMultiple = 0; // start loop from 20 onwards then increasing by 2520 each time
	}
	
	/**
	 * Returns true if number is a divisible by all natural numbers up till <number>
	 * @param number
	 * @return
	 */
	public boolean isMultipleUpToTwenty(Integer number) {
		
		if ((number.intValue() % 20 == 0) &&
			(number % 19 == 0) &&
			(number % 18 == 0) &&
			(number % 17 == 0) &&
			(number % 16 == 0) &&
			(number % 15 == 0) &&
			(number % 14 == 0) &&
			(number % 13 == 0) &&
			(number % 12 == 0) &&
			(number % 11 == 0)
			){
			return true;
		} 
		else {
			return false;
		}
	}

	
	/**
	 * Method to determine smallest multiple, by constantly stepping +20 (otherwise not divisible by 20)
	 * @param limit
	 * @return
	 */
	public Integer getSmallestMultiple() {
		boolean foundIt = false;
		System.out.println(" Start of getSmallestMultiple()");
		while (!foundIt) {
			this.smallestMultiple += 2520;
			if (isMultipleUpToTwenty(this.smallestMultiple)){
				foundIt = true;
			}
		}
		System.out.println(" End of getSmallestMultiple()");
		return this.smallestMultiple;
	}
	
	public static void main(String[] args){
        P005_SmallestMultiple p5 = new P005_SmallestMultiple();
        System.out.println(p5.getSmallestMultiple());
        
    }

}
