package hkol;

/**
 * @author Harm Kolvoort
 * @date 14-11-2014
 * 
 * Problem 1 Multiples of 3 and 5
 * If we list all the natural numbers below 10 
 * that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 * The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 */
public class P1_SumOfMultiples {
	private Integer sum;
	
	/**
	 * Constructor sets sum to zero. 
	 */
	public P1_SumOfMultiples() {
		sum = 0;
	}
	
	/**
	 * Returns true if number is a multiple of divider
	 * Example 1: 6 (number) is multiple of 3 (divider)
	 * Example 2: 8 (number) not multiple of 5 (divider)
	 * @param number
	 * @param divider
	 * @return
	 */
	public boolean isMultiple(Integer number, Integer divider) {
		if (number % divider == 0) {
			return true;
		} else {
			return false;
		}
	}

	
	/**
	 * Method to determine sum of multiples below (not including) limit
	 * @param multiple2
	 * @param limit
	 * @return
	 */
	public Integer sum(Integer multiple1, Integer multiple2, Integer limit) {
		for (int i=1; i<limit; i++) {
			if (isMultiple(i,multiple1) || isMultiple(i,multiple2)){
				sum += i;
			}
		}
		return sum;
	}

}
