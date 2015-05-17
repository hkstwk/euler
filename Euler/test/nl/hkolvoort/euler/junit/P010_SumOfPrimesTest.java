package nl.hkolvoort.euler.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;



import nl.hkolvoort.euler.P010_SumOfPrimes;
import nl.hkolvoort.euler.PrimeHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class P010_SumOfPrimesTest {
	private Long result;
	private Long expected;
	private String resultString;
	private String expectedString;

	@Before
	public void setUp() throws Exception {
		result = new Long(0);
		expected = new Long(0);
		System.out.println("Start of SumOfPrimesTest");
	}

	@After
	public void tearDown() throws Exception {
		result = null;
		expected = null;
		System.out.println("End of SumOfPrimesTest");
	}

	@Test
	public void testSumOfPrime10() {
		P010_SumOfPrimes sum = new P010_SumOfPrimes((long)10);
		expected = (long) 17;
		result = sum.getResult();
		assertEquals(expected, result);
	}

	@Test
	public void testPrintSumOfPrime10() {
		P010_SumOfPrimes sum = new P010_SumOfPrimes((long)10);
		expectedString = "2 + 3 + 5 + 7 = 17";
		resultString = sum.getFormattedResult();
		assertEquals(expectedString, resultString);
	}

	
	@Test
	public void testSumOfPrime2M() {
		P010_SumOfPrimes sum = new P010_SumOfPrimes((long) 2000000);
		expected = new Long("142913828922");
		result = sum.getResult();
		assertEquals(expected, result);
	}	

	@Test
	public void testSumOfPrime15() {
		P010_SumOfPrimes sum = new P010_SumOfPrimes((long)15);
		result = sum.getResult();
		expected = (long)41;
		assertEquals(expected, result);
	}	

	
	@Test
	public void testPrime2() {
		boolean isPrime = PrimeHelper.isPrime((long)2);
		assertTrue(isPrime);
	}

	@Test
	public void testPrime3() {
		boolean isPrime = PrimeHelper.isPrime((long) 3);
		assertTrue(isPrime);
	}

	@Test
	public void testPrime4() {
		boolean isPrime = PrimeHelper.isPrime((long) 4);
		assertFalse(isPrime);
	}

	@Test
	public void testPrime23() {
		boolean isPrime = PrimeHelper.isPrime((long) 23);
		assertTrue(isPrime);
	}

	@Test
	public void testPrime6() {
		boolean isPrime = PrimeHelper.isPrime((long) 6);
		assertFalse(isPrime);
	}
	
	@Test
	public void testHowManyPrimes6() {
		P010_SumOfPrimes n = new P010_SumOfPrimes((long) 6);
		result = PrimeHelper.getNumberOfPrimes(n.getPrimeList());
		expected = (long) 3;
		assertEquals(expected, result);
	}

	@Test
	public void testHowManyPrimes10() {
		P010_SumOfPrimes n = new P010_SumOfPrimes((long) 10);
		result = PrimeHelper.getNumberOfPrimes(n.getPrimeList());
		expected = (long) 4;
		assertEquals(expected, result);
	}
}

