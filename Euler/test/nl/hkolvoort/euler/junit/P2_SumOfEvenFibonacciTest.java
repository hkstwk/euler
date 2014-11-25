package nl.hkolvoort.euler.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import nl.hkolvoort.euler.P2_SumOfEvenFibonacci;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class P2_SumOfEvenFibonacciTest {
	private Integer result;
	private boolean isEvenFib;          // isEvenFibonnaci 
	private P2_SumOfEvenFibonacci soef; //Sum Of Even Fibonacci
	
	@Before
	public void setUp() throws Exception {
		this.result = 0;
		soef = new P2_SumOfEvenFibonacci();
	}

	@After
	public void tearDown() throws Exception {
		this.result = 0;
		soef = null;
	}

	/**
	 * Test if fibonacci number is even or uneven
	 * 5 is a fibonacci number that returns false;
	 */
	@Test
	public void testIsEvenFibonnaci() {
		isEvenFib = soef.isEvenFibonacci(5);
		assertFalse(isEvenFib);
	}
	
	/**
	 * Test if fibonacci number is even or uneven
	 * 34 is a fibonacci number that returns true;
	 */
	@Test
	public void testIsUnevenFibonnaci() {
		isEvenFib = soef.isEvenFibonacci(34);
		assertTrue(isEvenFib);
	}
	
	/**
	 * Fill ArrayList with first ten fibonacci numbers
	 * Last index should contain 34
	 */
	@Test
	public void testFillFibonacciList() {
		soef.setLimit(34);
		soef.fillFibonacciList();
		ArrayList<Integer> fibList = new ArrayList<Integer>();
		fibList = soef.getFibonacciList();
		Integer result = fibList.get(fibList.size()-1);
		Integer expected = 34;
		assertEquals(expected,result);
	}
	
	/**
	 * Fill ArrayList with first ten fibonacci numbers
	 * Sum of even fibonacci numbers is 44
	 */
	@Test
	public void testSumEvenFibonacciList() {
		soef.setLimit(35);
		soef.fillFibonacciList();
		soef.sumEvenFibonacciNumbers();
		Integer result = soef.getSumEvenFibonacci();
		Integer expected = 44;
		assertEquals(expected,result);
	}
	
	/**
	 * Fill ArrayList with first ten fibonacci numbers
	 * Last index should contain 34
	 */
	@Test
	public void testSumEvenFibonacciList4M() {
		soef.setLimit(4000000);
		soef.fillFibonacciList();
		soef.sumEvenFibonacciNumbers();
		Integer result = soef.getSumEvenFibonacci();
		Integer expected = 4613732;
		assertEquals(expected,result);
	}
	
	/**
	 * Fill ArrayList with first ten fibonacci numbers
	 * Last index should contain 34
	 */
	@Test
	public void testRecursiveSumEvenFibonacciList4M() {
		soef.setLimit(4000000);
		soef.fillFibonacciList();
		soef.sumEvenFibonacciNumbers();
		Integer result = soef.getSumEvenFibonacci();
		Integer expected = 4613732;
		assertEquals(expected,result);
	}
		
}
