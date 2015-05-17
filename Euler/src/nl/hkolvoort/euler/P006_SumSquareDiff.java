package nl.hkolvoort.euler;

/**
 * @author Harm Kolvoort
 * @date 11-5-2015
 * 
 * Problem 6: The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * 
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * 
 * Hence the difference between the sum of the squares of the first 
 * ten natural numbers and the square of the sum is 3025 - 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first 
 * one hundred natural numbers and the square of the sum.
 * 
 */

public class P006_SumSquareDiff {

	private Integer sumOfSquares;
	private Integer squareOfSum;
	private Integer count;
	
	/**
	 * Constructor: create triangle ArrayList
	 */
	public P006_SumSquareDiff(Integer count){
		this.count = count;
		this.sumOfSquares = new Integer(0);
		this.squareOfSum = new Integer(0);
	}

	public P006_SumSquareDiff(){
		this.count = 10;
		this.sumOfSquares = new Integer(0);
		this.squareOfSum = new Integer(0);
	}
	
	public Integer getDifference(){
		for (int i=1; i<=this.count; i++){
			squareOfSum += i;
			sumOfSquares = sumOfSquares + i*i; 
			System.out.println("square of sum: " + squareOfSum + "  /  sum of squares: " + sumOfSquares);
		}
		squareOfSum = squareOfSum * squareOfSum;
		System.out.println("square of sum: " + squareOfSum + "  /  sum of squares: " + sumOfSquares);
		return squareOfSum - sumOfSquares;
	}
	
    public static void main(String[] args){
        P006_SumSquareDiff p6 = new P006_SumSquareDiff(100);
        System.out.println("The difference is: " + p6.getDifference()); 
    }
}
