package unit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import hkol.SumOfPrimes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SumOfPrimesTest {
	private Long result;
	private Long expected;

	@Before
	public void setUp() throws Exception {
		result = new Long(0);
		expected = new Long(0);
	}

	@After
	public void tearDown() throws Exception {
		result = null;
		expected = null;	
	}

	@Test
	public void testSumOfPrime10() {
		SumOfPrimes sum = new SumOfPrimes((long)10);
		expected = (long) 17;
		result = sum.getResult();
		assertEquals(expected, result);
	}
	
	@Test
	public void testSumOfPrime2M() {
		SumOfPrimes sum = new SumOfPrimes((long) 2000000);
		expected = new Long("142913828922");
		result = sum.getResult();
		assertEquals(expected, result);
	}	

	@Test
	public void testSumOfPrime15() {
		SumOfPrimes sum = new SumOfPrimes((long)15);
		result = sum.getResult();
		expected = (long)41;
		assertEquals(expected, result);
	}	

	
	@Test
	public void testPrime2() {
		SumOfPrimes n = new SumOfPrimes((long)2);
		boolean isPrime = n.isPrime((long)2);
		assertTrue(isPrime);
	}

	@Test
	public void testPrime3() {
		SumOfPrimes n = new SumOfPrimes((long) 3);
		boolean isPrime = n.isPrime((long) 3);
		assertTrue(isPrime);
	}

	@Test
	public void testPrime4() {
		SumOfPrimes n = new SumOfPrimes((long) 4);
		boolean isPrime = n.isPrime((long) 4);
		assertFalse(isPrime);
	}

	@Test
	public void testPrime23() {
		SumOfPrimes n = new SumOfPrimes((long) 23);
		boolean isPrime = n.isPrime((long) 23);
		assertTrue(isPrime);
	}

	@Test
	public void testPrime6() {
		SumOfPrimes n = new SumOfPrimes((long) 6);
		boolean isPrime = n.isPrime((long) 6);
		assertFalse(isPrime);
	}
	
	@Test
	public void testHowManyPrimes6() {
		SumOfPrimes n = new SumOfPrimes((long) 6);
		result = n.getNumberOfPrimes();
		expected = (long) 3;
		assertEquals(expected, result);
	}

	@Test
	public void testHowManyPrimes10() {
		SumOfPrimes n = new SumOfPrimes((long) 10);
		result = n.getNumberOfPrimes();
		expected = (long) 4;
		assertEquals(expected, result);
	}
}

