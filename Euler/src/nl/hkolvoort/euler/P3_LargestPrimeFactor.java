package nl.hkolvoort.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Harm
 * @date 25-Nov-2014
 * 
 *       Problem 3: Largest Prime Factor The prime factors of 13195 are 5, 7, 13
 *       and 29. What is the largest prime factor of the number 600851475143?
 * 
 *       Brute force approach is way too slow. Does work with small numbers but
 *       with this 12 digit number simply runs forever. Lost patience and
 *       aborted the run. Approach used here is bruto force with small but
 *       clever adjustment which I found at:
 *       http://www.mathblog.dk/project-euler-problem-3/
 * 
 *       Any factor less than the square root of the number we check, will have
 *       corresponding factor larger than the square root of the number. So we
 *       only need to check up to the square root of the number, and then we can
 *       deduct the remaining factors. Example: The number 24, has the factors
 *       2, 3, 4, 6, 8 and 12. The square root of 24 is approximately 4.8, so we
 *       are save to check all numbers up to and including 4. This gives us 2,3
 *       and 4 as factors. The rest can be deducted as: 24/2 = 12; 24/3 = 8;
 *       24/4 = 6
 * 
 *       Even More info: http://www.mathsisfun.com/prime-factorization.html
 * 
 */
public class P3_LargestPrimeFactor {
	private ArrayList<Long> primeList;
	private Long input;

	public P3_LargestPrimeFactor(Long input) {
		this.primeList = PrimeHelper.fillPrimeArray((long) Math.sqrt(input));
		this.input = input;
	}

	public Long calcLargestPrimeFactor() {
		Long lpf = new Long(0);
		for (int i = 0; i < this.primeList.size(); i++) {
			if (input % this.primeList.get(i) == 0
					&& this.primeList.get(i) > lpf)
				lpf = this.primeList.get(i);
		}
		return (long) lpf;
	}
	
	public Long primeFactorization(){
		Long newnumm = this.input;
		Long largestFact = (long) 0;
		int counter = 2;
		while (counter * counter <= newnumm) {
		    if (newnumm % counter == 0) {
		        newnumm = newnumm / counter;
		        largestFact = (long) counter;
		    } else {
		        counter++;
		    }
		}
		if (newnumm > largestFact) { // the remainder is a prime number
		    largestFact = newnumm;
		}
		return largestFact;
	}

	public ArrayList<Long> getPrimeList() {
		return this.primeList;
	}

	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter number : ");
		String number = null;
		try {
			number = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("You entered : " + number);
		
		P3_LargestPrimeFactor p3 = new P3_LargestPrimeFactor(new Long(number));
		System.out.println("Largest Prima Factor of " + number + " = " + p3.primeFactorization());
	}

}
